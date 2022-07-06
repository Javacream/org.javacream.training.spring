package org.javacream.books;

import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.javacream.util.stage.ProdConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@ProdConfiguration
public class BooksConfiguration {
    @Bean @Qualifier("booksData") public Map<String, Book> booksData(){
        return new HashMap<>();
    }
    @Bean @Qualifier("orderData") public Map<Long, Order> orderData(){
        return new HashMap<>();
    }
}
