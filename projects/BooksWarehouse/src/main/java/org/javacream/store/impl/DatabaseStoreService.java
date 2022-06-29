package org.javacream.store.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.javacream.store.api.StoreService;
import org.javacream.util.aspects.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DatabaseStoreService implements StoreService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private DataSource dataSource;

	@Override
	@Audit
	public int getStock(String category, String item) {
		Query query = entityManager.createNativeQuery("select stock from store where category=:cat and item = :item");
		query.setParameter("cat", category);
		query.setParameter("item", item);
		try {
			return (int) query.getSingleResult();
		} catch (NoResultException e) {
			return 0;
		}
	}

	@Override
	@Audit
	public void setStock(String category, String item, int stock) {
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement statement = con
					.prepareStatement("insert into store (category, item, stock) values (?1, ?2, ?3)");
			statement.setString(1, category);
			statement.setString(2, item);
			statement.setInt(3, stock);
			statement.executeUpdate();
		} catch (SQLException e) {
			try {
				Connection con = dataSource.getConnection();
				PreparedStatement statement = con
						.prepareStatement("update store set stock = ?1 where category = ?2 and item = ?3)");
				statement.setInt(1, stock);
				statement.setString(2, category);
				statement.setString(3, item);
				statement.executeUpdate();
			} catch (SQLException e2) {
				throw new RuntimeException(e2);
			}
		}
	}

}
