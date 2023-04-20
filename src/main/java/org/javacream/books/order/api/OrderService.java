package org.javacream.books.order.api;

public interface OrderService {
    Order order(String isbn, int number);
    Order findOrderById(long orderId);
}
