package org.javacream.store.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DatabaseStoreService implements StoreService {

	@Autowired private JdbcTemplate jdbcTemplate;
	@PersistenceContext private EntityManager entityManager;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int getStock(String category, String item) {
		jdbcTemplate.queryForObject("", null, Integer.class);
		entityManager.createNativeQuery("").getSingleResult();
		return 0;
	}

}
