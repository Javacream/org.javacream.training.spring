package org.javacream.store.impl;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.javacream.store.api.StoreService;

public class TestStoreServicePlain implements StoreService {

	private DataSource dataSource;
	
	private EntityManager entityManager;

	public TestStoreServicePlain(DataSource dataSource, EntityManager entityManager) {
		super();
		this.dataSource = dataSource;
		this.entityManager = entityManager;
	}

	@Override
	public int getStock(String category, String item) {
		System.out.println("PLAIN: DataSource=" + this.dataSource + ", EntityManager=" + this.entityManager);
		return 0;
	}

}
