package org.javacream.books.warehouse.test;

import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.javacream.util.stage.TestConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@TestConfiguration
public class BookServiceTestConfiguration {
    @Bean @Qualifier("booksData")
    public Map<String, Book> books(){
        HashMap<String, Book> books = new HashMap<>();
        for (int i = 1; i <= 5; i++){
            Book b = new Book();
            b.setIsbn("Isbn" + i);
            b.setTitle("Title" + i);
            b.setPrice(1.99 * i);
            books.put(b.getIsbn(), b);
        }
        return books;
    }
    @Bean @Qualifier("orderData")
    public Map<Long, Order> orderData() {
        HashMap<Long, Order> data = new HashMap<>();
        Order orderOk = new Order(1l, "ISBN1", 100, 199.00, Order.OrderStatus.OK);
        Order orderPending = new Order(2l, "ISBN2", 100, 199.00, Order.OrderStatus.PENDING);
        Order orderUnavailable = new Order(3l, "ISBN3", 100, 199.00, Order.OrderStatus.UNAVAILABLE);
        data.put(orderOk.getOrderId(), orderOk);
        data.put(orderPending.getOrderId(), orderPending);
        data.put(orderUnavailable.getOrderId(), orderUnavailable);
        return data;

    }
}
