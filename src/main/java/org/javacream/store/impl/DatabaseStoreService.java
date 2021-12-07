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
		// select stock from store where category = 'books' and item = 'ISBN1'
		try {
			Query query = entityManager
					.createNativeQuery("select stock from store where category = :category and item = :item");
			query.setParameter("category", category);
			query.setParameter("item", item);
			Integer result = (Integer) query.getSingleResult();
			if (result == null) {
				return 0;
			} else {
				return result;
			}
		}

		catch (RuntimeException e) {
			return 0;
		}
	}

}
