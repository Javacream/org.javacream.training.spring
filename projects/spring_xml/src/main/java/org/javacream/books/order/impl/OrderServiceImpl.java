package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.SequenceGenerator;

public class OrderServiceImpl implements OrderService{
	private StoreService storeService;
	private BooksService booksService;
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}
	public void setSequenceGenerator(SequenceGenerator sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}
	private SequenceGenerator sequenceGenerator;
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
		return new Order(id, isbn, amount, totalPrice, status);
	}

}
