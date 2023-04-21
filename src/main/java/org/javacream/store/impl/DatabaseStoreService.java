package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class DatabaseStoreService implements StoreService {

	@PersistenceContext
	EntityManager entityManager;
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int getStock(String category, String item) {
		Query query = entityManager.createNativeQuery("select stock from store where category=:cat and item=:item");
		query.setParameter("cat", category);
		query.setParameter("item", item);
		try {
			int stock = (int) query.getSingleResult();
			return stock;
		}
		catch (RuntimeException re){
			System.out.println(re.getMessage());
			return 0;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void setStock(String category, String item, int stock) {
		Query query = entityManager.createNativeQuery("delete from store where category=:cat and item=:item");
		query.setParameter("cat", category);
		query.setParameter("item", item);
		query.executeUpdate();
		query = entityManager.createNativeQuery("insert into store (category, item, stock) values(:cat, :item, :stock)");
		query.setParameter("cat", category);
		query.setParameter("item", item);
		query.setParameter("stock", stock);
		query.executeUpdate();
		}
	}


