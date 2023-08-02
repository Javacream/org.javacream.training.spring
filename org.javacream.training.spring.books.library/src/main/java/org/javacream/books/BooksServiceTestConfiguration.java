package org.javacream.books;

import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("test")
public class BooksServiceTestConfiguration {

    @Bean
    public Map<String, Book> booksMap(){
        Map<String, Book> books = new HashMap<>();
        Book book = new Book();
        book.setIsbn("ISBN1");
        book.setTitle("Title1");
        book.setPrice(19.99);
        books.put("ISBN1", book);
        return books; //Dependency Outjection ("Sawitzki")
    }

    @Bean Map<Long, Order> ordersMap(){
        return new HashMap<>();
    }


}
