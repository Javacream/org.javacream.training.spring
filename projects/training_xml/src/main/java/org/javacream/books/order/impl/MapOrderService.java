package org.javacream.books.order.impl;

import java.util.Map;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.SequenceGenerator;

public class MapOrderService implements OrderService {

	private Map<Long, Order> orders;

	private BooksService booksService;

	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public void setSequenceGenerator(SequenceGenerator sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}

	private StoreService storeService;
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
			} else {
				status = OrderStatus.PENDING;
			}
		}

		catch (BookException e) {
			status = OrderStatus.UNAVAILABLE;
		}
		Order order = new Order(orderId, isbn, number, totalPrice, status);
		orders.put(order.getOrderId(), order);
		return order;
	}

	@Override
	public Order findOrderById(long id) {
		return orders.get(id);
	}

}
