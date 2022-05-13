package org.javacream.books.order.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.BooksService.InMemory;
import org.javacream.store.api.StoreService;
import org.javacream.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired @org.javacream.store.api.StoreService.Database private StoreService storeService;
	@Autowired @InMemory private BooksService booksService;
	@Autowired private SequenceGenerator sequenceGenerator;
	@PersistenceContext private EntityManager entityManager;

	@Override
	public Order order(String isbn, int amount) {
		
		OrderStatus status;
		long id = sequenceGenerator.nextSequence();
		double totalPrice = 0;
		try {
			Book book = booksService.findBookByIsbn(isbn);
			if (storeService.getStock("books", isbn) >= amount) {
				status = OrderStatus.OK;
				totalPrice = amount * book.getPrice();
			}else {
				status = OrderStatus.PENDING;
			}
		}
		catch(BookException e) {
			status = OrderStatus.UNAVAILABLE;
		}
		Order order = new Order(id, isbn, amount, totalPrice, status);
		entityManager.persist(order);
		return order;
	}
	@Override
	public Order findOrderById(long id) {
		return entityManager.find(Order.class, id);
	}

}
