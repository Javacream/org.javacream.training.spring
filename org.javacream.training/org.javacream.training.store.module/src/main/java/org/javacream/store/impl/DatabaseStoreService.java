package org.javacream.store.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.store.api.StoreService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Profile("prod")
@Transactional(propagation = Propagation.REQUIRED)
@EnableBinding(Sink.class)
public class DatabaseStoreService implements StoreService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int getStock(String category, String item) {
		// Projektionsabfrage als Transaktionsskript
		String sql = "select stock from store where category=:category and item=:item";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("category", category);
		query.setParameter("item", item);
		int result;

		try {
			result = (int) query.getSingleResult();
		} catch (RuntimeException re) {
			result = 0;
		}
		return result;
	}
	
	@StreamListener(Sink.INPUT)
	public void updateStock(String isbn) {
		System.out.println("I S B N " + isbn);
		String sql = "insert into store (category, item, stock) values ('books', :isbn, 10)";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("isbn", isbn);
		query.executeUpdate();
		
		
	}

}
