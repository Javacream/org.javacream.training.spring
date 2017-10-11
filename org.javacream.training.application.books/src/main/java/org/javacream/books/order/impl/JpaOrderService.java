package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.api.OrderStatus;
import org.javacream.books.order.jpa.OrderRepository;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaOrderService implements OrderService{
	@Autowired private BooksService booksService;
	@Autowired private StoreService storeService;
	@Autowired private OrderRepository orderRepository;
	@Override
	public Order createOrder(String isbn, int number) {
		OrderStatus orderStatus;
		Double totalPrice = 0.0;
		try {
			Book book = booksService.findBookByIsbn(isbn);
			totalPrice = book.getPrice()*number;
			int stock = storeService.getStock("books", isbn);
			if (stock >= number) {
				orderStatus = OrderStatus.OK;
			}else {
				orderStatus = OrderStatus.PENDING;
			}
		}
		catch(BookException e) {
			orderStatus = OrderStatus.UNAVAILABLE;
		}
		
		Order order =  new Order(null, isbn, totalPrice, orderStatus);
		orderRepository.save(order);
		return order;
	}
	
	
	
}
