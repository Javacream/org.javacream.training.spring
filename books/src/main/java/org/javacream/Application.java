package org.javacream;

import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {
    @Bean @Qualifier("books")
    public Map<String, Book> books(){
        HashMap<String, Book> books = new HashMap<>();
        Book book1 = new Book("Isbn1", "Title1", 200, 19.99, true);
        Book book2 = new Book("Isbn2", "Title2", 200, 9.99, false);
        Book book3 = new Book("Isbn3", "Title3", 200, 29.99, true);
        books.put(book1.getIsbn(), book1);
        books.put(book2.getIsbn(), book2);
        books.put(book3.getIsbn(), book3);
        return books;
    }
    @Bean @Qualifier("orders")
    public Map<Long, Order> orders(){
        Map<Long, Order> orders = new HashMap<>();
        Order order1 = new Order(1001l, "Isbn1001", 1, 19.99, "meier", Order.OrderStatus.OK);
        Order order2 = new Order(1002l, "Isbn1002", 1, 9.99, "meier", Order.OrderStatus.OK);
        Order order3 = new Order(1003l, "Isbn1003", 1, 39.99, "metzger", Order.OrderStatus.PENDING);
        Order order4 = new Order(1004l, "Isbn1001", 1, 0d, "meier", Order.OrderStatus.UNAVAILABLE);
        Order order5 = new Order(1005l, "Isbn1002", 1, 444.99, "schneider", Order.OrderStatus.PENDING);
        Order order6 = new Order(1006l, "Isbn1002", 1, 0d, "metzger", Order.OrderStatus.UNAVAILABLE);
        orders.put(order1.getOrderId(), order1);
        orders.put(order2.getOrderId(), order2);
        orders.put(order3.getOrderId(), order3);
        orders.put(order4.getOrderId(), order4);
        orders.put(order5.getOrderId(), order5);
        orders.put(order6.getOrderId(), order6);
        return orders;
    }
}
