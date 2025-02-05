package org.javacream.books.order;

public interface OrderService {
    long order(String isbn, int amount);
    Order findById(Long id);
}
