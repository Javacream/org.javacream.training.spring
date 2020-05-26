package org.javacream.store.impl;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.javacream.store.api.StoreService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"test", "constructor"})
public class TestStoreServiceWithConstructorInjection implements StoreService {

	private DataSource dataSource;
	
	private EntityManager entityManager;
	String message;

	public TestStoreServiceWithConstructorInjection(DataSource dataSource, EntityManager entityManager) {
		super();
		this.dataSource = dataSource;
		this.entityManager = entityManager;
	}

	@Override
	public int getStock(String category, String item) {
		System.out.println("CONSTRUCTOR: DataSource=" + this.dataSource + ", EntityManager=" + this.entityManager);
		return 0;
	}

}
