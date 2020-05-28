package org.javacream.books.order.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SimpleOrderService {

	@Autowired private BooksService booksService;
	@Autowired private StoreService storeService;
	@PersistenceContext private EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean order(String isbn, int amount) {
		try {
			booksService.findBookByIsbn(isbn);
			int stock = storeService.getStock("books", isbn);
			if (stock >= amount) {
				Query query = em.createNativeQuery("insert into BOOKSORDER values (:isbn, :amount)");
				query.setParameter("isbn", isbn);
				query.setParameter("amount", amount);
				query.executeUpdate();
				storeService.updateStock("books", isbn, -amount);
				return true;
			}else {
				return false;
			}
		} catch (BookException e) {
			throw new RuntimeException(e);
			
		}
	}
}
