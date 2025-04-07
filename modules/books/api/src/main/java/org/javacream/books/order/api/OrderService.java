package org.javacream.books.order.api;

public interface OrderService {
    Long order(String isbn, Integer amount);
    Order findById(Long id);
}
