package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("test")
public class BookServiceTestConfiguration {
    @Bean
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
}
