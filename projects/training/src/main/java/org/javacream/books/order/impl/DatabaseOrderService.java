package org.javacream.books.order.impl;

import javax.persistence.EntityManager;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Plain;
import org.javacream.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DatabaseOrderService implements OrderService {

	@Autowired private EntityManager entityManager;
	@Autowired @Qualifier("undecorated")
	private BooksService booksService;
	@Autowired @Plain
	private StoreService storeService;
	@Autowired
	private SequenceGenerator sequenceGenerator;

	@Override
	public Order order(String isbn, int number) {
		long orderId = sequenceGenerator.nextInSequence();
		double totalPrice = 0;
		OrderStatus status;
		try {
			Book book = booksService.findBookByIsbn(isbn);
			totalPrice = number * book.getPrice();
			if (number <= storeService.getStock("books", isbn)) {
				status = OrderStatus.OK;
			}else {
				status = OrderStatus.PENDING;
			}
		}

		catch (BookException e) {
			status = OrderStatus.UNAVAILABLE;
		}
		Order order = new Order(orderId, isbn, number, totalPrice, status);
		entityManager.persist(order);
		return order;
	}

	@Override
	public Order findOrderById(long id) {
		return entityManager.find(Order.class, id);
	}

}
