package org.javacream.books.config;

import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.books.warehouse.impl.decorators.DeepCloneBooksService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BooksConfig {
    @Bean @Primary
    public BooksService booksService(MapBooksService mapBooksService){
        DeepCloneBooksService deepCloneBooksService = new DeepCloneBooksService();
        deepCloneBooksService.setDelegate(mapBooksService);
        return deepCloneBooksService;
    }
}
