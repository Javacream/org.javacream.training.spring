package org.javacream.books.order.api;

import java.util.List;

public interface OrderService {

	Order order(String isbn, int number);

	List<Order> allOrders();
}
