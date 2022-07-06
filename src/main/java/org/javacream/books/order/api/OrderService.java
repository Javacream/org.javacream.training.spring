package org.javacream.books.order.api;

public interface OrderService {
	
	Order order(String isbn, int amount);
	Order findOrderById(long id);

}
