package org.javacream.store.impl;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseStoreService implements StoreService {
	
	@Autowired private EntityManager entityManager;
	@Override
	public int getStock(String category, String item) {
		Query query = entityManager.createNativeQuery("select stock from STORE where category=:cat and item=:item");
		query.setParameter("cat", category);
		query.setParameter("item", item);
		try {
			Object result = query.getFirstResult();
			return (int)result;
		}
		catch(NoResultException e) {
			return 0;
		}
		
	}

}
