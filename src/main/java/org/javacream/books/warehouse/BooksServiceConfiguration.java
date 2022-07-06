package org.javacream.books.warehouse;

import org.javacream.books.warehouse.api.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("prod")
public class BooksServiceConfiguration {
    @Bean
    public Map<String, Book> books(){
        HashMap<String, Book> books = new HashMap<>();
        return books;
    }

}
