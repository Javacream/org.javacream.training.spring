package org.javacream.store.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatabaseStoreService implements StoreService {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public int getStock(String category, String item) {
		Query query = entityManager.createNativeQuery("select stock from store where category=:cat and itemid=:id");
		query.setParameter("cat", category);
		query.setParameter("id", item);
		try {
			return (int) query.getSingleResult();
		} catch (Exception e) {
			return 0;
		}
	}

}
