package org.javacream.books.order.api;

import java.util.List;

public interface OrderService {
    Order order(String isbn, Integer number, String customer);
    List<Order> allOrders();
    Order findOrderById(Long id);
    List<Order> findOrdersByIsbn(String isbn);
    List<Order> findOrdersByCustomer(String customer);

}
