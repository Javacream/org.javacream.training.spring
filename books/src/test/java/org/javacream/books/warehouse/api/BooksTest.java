package org.javacream.books.warehouse.api;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class BooksTest {
    @Autowired private BooksService booksService;
    @Test public void doTestBooks() throws BookException{
        Book book1 = new Book("ISBN_X", "Title1", 100, 19.99, true);
        booksService.newBook(book1);
        Book searchResult = booksService.findBookByIsbn(book1.getIsbn());
        Assertions.assertEquals(book1, searchResult);
        booksService.deleteBookByIsbn(book1.getIsbn());
    }
}
