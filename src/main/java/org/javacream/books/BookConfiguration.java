package org.javacream.books;

import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BookConfiguration {
        @Bean
        Map<String, Book> data(){
            Map<String, Book> data = new HashMap<>();
            return data;
        }

}
