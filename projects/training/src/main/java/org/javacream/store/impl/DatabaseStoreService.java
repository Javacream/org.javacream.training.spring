package org.javacream.store.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Plain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Plain
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class DatabaseStoreService implements StoreService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int getStock(String category, String item) {
		Query query = entityManager.createNativeQuery("select stock from store where category=:cat and item=:item");
		query.setParameter("cat", category);
		query.setParameter("item", item);
		try {
			int result = (int) query.getSingleResult();
			return result;
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	@Override
	public void saveOrUpdateStock(String category, String item, int stock) {
		Query query = entityManager.createNativeQuery("select stock from store where category=:cat and item=:item");
		query.setParameter("cat", category);
		query.setParameter("item", item);
		try {
			query.getSingleResult();
			Query updateQuery = entityManager
					.createNativeQuery("update store set stock=:stock where category=:cat and item=:item");
			updateQuery.setParameter("cat", category);
			updateQuery.setParameter("item", item);
			updateQuery.setParameter("stock", stock);
			updateQuery.executeUpdate();
		} catch (RuntimeException e) {
			Query insertQuery = entityManager
					.createNativeQuery("insert into store (category, item, stock) values(:cat, :item, :stock)");
			insertQuery.setParameter("cat", category);
			insertQuery.setParameter("item", item);
			insertQuery.setParameter("stock", stock);
			insertQuery.executeUpdate();

		}

	}

}
