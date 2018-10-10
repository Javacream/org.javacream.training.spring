package org.javacream.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.javacream.books.warehouse.api.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaDemo2 {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void doSomething() {
		System.out.println("Starting demo");
		Book b = entityManager.find(Book.class, "ISBN");
		b.setPrice(129.98);
	}

}
