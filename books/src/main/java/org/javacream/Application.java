package org.javacream;

import org.javacream.books.warehouse.api.Book;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {
    @Bean public Map<String, Book> books(){
        HashMap<String, Book> books = new HashMap<>();
        Book book1 = new Book("Isbn1", "Title1", 200, 19.99, true);
        Book book2 = new Book("Isbn2", "Title2", 200, 9.99, false);
        Book book3 = new Book("Isbn3", "Title3", 200, 29.99, true);
        books.put(book1.getIsbn(), book1);
        books.put(book2.getIsbn(), book2);
        books.put(book3.getIsbn(), book3);
        return books;
    }
}
