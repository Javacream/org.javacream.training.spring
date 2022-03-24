package org.javacream.store.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatabaseStoreService implements StoreService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public int getStock(String category, String item) {
		Query query = entityManager.createNativeQuery("select stock from STORE where category= :cat and item = :item");
		query.setParameter("cat", category);
		query.setParameter("item", item);
		try {
			return (int) query.getSingleResult();
		} catch (RuntimeException e) {
			return 0;
		}
	}

}
