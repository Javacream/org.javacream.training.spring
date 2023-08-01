package org.javacream.books.warehouse.config;

import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BooksServiceConfiguration {

    @Bean @Scope("singleton")
    public Map<String, Book> booksMap(){
        System.out.println("************ creating books map using " + this);
        Map<String, Book> books = new HashMap<>();
        Book book = new Book();
        book.setIsbn("Isbn1");
        book.setTitle("Title1");
        book.setPrice(19.99);
        books.put("Isbn1", book);
        return books; //Dependency Outjection ("Sawitzki")
    }

    @Bean Map<Long, Order> ordersMap(){
        System.out.println("************ creating orders map using " + this);
        Map<String, Book> books = booksMap();
        books = booksMap();
        books = booksMap();
        books = booksMap();
        return new HashMap<>();
    }


}
