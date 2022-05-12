package org.javacream.books.order.impl;

import java.io.ObjectStreamConstants;
import java.util.Map;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService, ObjectStreamConstants {
	@Autowired private StoreService storeService;
	@Autowired private BooksService booksService;
	@Autowired private SequenceGenerator sequenceGenerator;
	@Autowired @Qualifier("orderData") private Map<Long, Order> orders;
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
		orders.put(id, order);
		return order;
	}
	@Override
	public Order findOrderById(long id) {
		return orders.get(id);
	}

}
