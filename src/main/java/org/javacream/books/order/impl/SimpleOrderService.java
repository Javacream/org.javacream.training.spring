package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleOrderService implements OrderService {

	@Autowired
	private BooksService booksService;
	@Autowired
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
		return new Order(orderId, isbn, number, totalPrice, status);
	}

}