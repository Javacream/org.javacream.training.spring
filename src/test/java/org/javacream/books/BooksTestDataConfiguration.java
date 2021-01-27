package org.javacream.books;

import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("test")
public class BooksTestDataConfiguration {
    @Bean
    Map<String, Book> testData(){
       Map<String, Book> data = new HashMap<>();
       Book b = new Book();
       b.setIsbn("TEST-ISBN");
       b.setTitle("TEST");
       b.setPrice(9.99);
       data.put("TEST-ISBN", b);
       return data;
    }
}
