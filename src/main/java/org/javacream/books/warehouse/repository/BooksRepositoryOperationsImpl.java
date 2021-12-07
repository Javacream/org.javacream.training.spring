package org.javacream.books.warehouse.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

public class BooksRepositoryOperationsImpl implements BooksRepositoryOperations {

	@PersistenceContext private EntityManager entityManager;

	@Override
	@Transactional
	public void discountPrices(double discount) {
		Query query = entityManager.createNativeQuery("update BOOK set price = price *:discount");
		query.setParameter("discount", discount);
		query.executeUpdate();
	}


}
