package org.javacream.store.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.javacream.store.api.StoreEntity;
import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Service;

@Service
public class JpaStoreService implements StoreService {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int getStock(String category, String item) {
		TypedQuery<StoreEntity> query = entityManager
				.createQuery("select s from StoreEntity as s where category = :cat and item = :item", StoreEntity.class);
		query.setParameter("cat", category);
		query.setParameter("item", item);
		try {
			return query.getSingleResult().getStock();
		} catch (Exception e) {
			return 0;
		}
	}

}
