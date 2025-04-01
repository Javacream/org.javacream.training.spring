package org.javacream.books.order.api;

public interface OrderService {
    Long order(String isbn, int amount);
    Order findById(Long id);
}
