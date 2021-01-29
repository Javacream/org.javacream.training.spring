package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Service
@Transactional
public class DatabaseStoreService implements StoreService {
	@PersistenceContext private EntityManager entityManager;
	@Override
	public int getStock(String category, String item) {
		try {
			Query query = entityManager.createNativeQuery("select stock from store where category = :category and item = :item");
			query.setParameter("category", category);
			query.setParameter("item", item);
			return (Integer)query.getSingleResult();
		}catch(RuntimeException e){
			System.out.println(e.getMessage());
			return 0;
		}

	}

}
