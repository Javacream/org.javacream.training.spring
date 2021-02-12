package org.javacream.store.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class DatabaseStoreService implements StoreService{
	@PersistenceContext() private EntityManager entityManager;
	@Override
	public int getStock(String category, String item) {
		Query query = entityManager.createNativeQuery("select stock from store where category = :cat and item = :itemId");
		query.setParameter("cat", category);
		query.setParameter("itemId", item);
		try{
			return (int) query.getSingleResult();
		}
		catch(RuntimeException re) {
			return 0;
		}
	}


}
