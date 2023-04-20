package org.javacream.books;

import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("test")
public class TestDataConfiguration {
    public @Bean @Qualifier("books") Map<String, Book> booksMap(){
        HashMap<String, Book> books = new HashMap<>();
        Book book = new Book();
        book.setIsbn("Isbn1");
        book.setTitle("Title1");
        book.setPrice(19.99);
        books.put("Isbn1", book);
        return books;
    }
    public @Bean @Qualifier("orders") Map<Long, Order> ordersMap(){
        HashMap<Long, Order> orders = new HashMap<>();
        Order order1 = new Order(1l, "ISBN1", 10, 19.99, Order.OrderStatus.OK);
        Order order2 = new Order(2l, "ISBN2", 10, 19.99, Order.OrderStatus.PENDING);
        Order order3 = new Order(3l, "ISBN3", 10, 0.0, Order.OrderStatus.UNAVAILABLE);
        orders.put(order1.getOrderId(), order1);
        orders.put(order2.getOrderId(), order2);
        orders.put(order3.getOrderId(), order3);
        return orders;
    }

}
