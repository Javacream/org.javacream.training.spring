package org.javacream.store.impl;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"test", "autowired attribute"})
public class TestStoreService implements StoreService {

	@Autowired private DataSource dataSource;
	
	@Autowired private EntityManager entityManager;

	@Override
	public int getStock(String category, String item) {
		System.out.println("AUTOWIRED ATTRIBUTE: DataSource=" + this.dataSource + ", EntityManager=" + this.entityManager);
		return 0;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
