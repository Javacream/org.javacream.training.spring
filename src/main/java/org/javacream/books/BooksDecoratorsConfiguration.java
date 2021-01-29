package org.javacream.books;

import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.decorator.SerializingBooksService;
import org.javacream.books.warehouse.impl.JpaBooksService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BooksDecoratorsConfiguration {

    @Bean @Qualifier("forApplication") public BooksService booksServiceForBookActor(JpaBooksService mapBooksService){
        SerializingBooksService serializingBooksService = new SerializingBooksService();
        serializingBooksService.setDelegate(mapBooksService);
        return serializingBooksService;
    }
    @Bean @Qualifier("forOrderActor") public BooksService booksServiceForOrderActor(JpaBooksService mapBooksService){
        return mapBooksService;
    }
}
