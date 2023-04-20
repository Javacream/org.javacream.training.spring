package org.javacream;

import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class JavacreamApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(JavacreamApplication.class);
        springApplication.setAdditionalProfiles("prod");
        springApplication.run(args);
    }

    public @Bean @Profile("prod")
    @Qualifier("books")
    Map<String, Book> booksMap(){
        HashMap<String, Book> books = new HashMap<>();
        return books;
    }
    public @Bean @Profile("prod") @Qualifier("orders") Map<Long, Order> ordersMap(){
        HashMap<Long, Order> orders = new HashMap<>();
        return orders;
    }
}
