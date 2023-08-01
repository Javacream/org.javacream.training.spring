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
@ComponentScan(basePackages = "org.javacream")
@Profile("prod")
public class BooksServiceProdConfiguration {

    @Bean
    public Map<String, Book> booksMap(){
        return new HashMap<>();
    }

    @Bean Map<Long, Order> ordersMap(){
        return new HashMap<>();
    }


}
