package org.javacream.books.warehouse.impl;

import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.decorators.CloningBooksService;
import org.javacream.books.warehouse.impl.decorators.TracingBooksService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BooksServiceConfiguration {

    public @Bean
    BooksService booksService(MapBooksService mapBooksService, TracingBooksService tracingBooksService, CloningBooksService cloningBooksService){
        cloningBooksService.setDelegate(mapBooksService);
        tracingBooksService.setDelegate(cloningBooksService);
        return tracingBooksService;
    }
}
