package org.javacream.books.warehouse.api;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BooksTest {
    private BooksService booksService;
    @BeforeEach
    public void init() throws BookException {
        MapBooksService mapBooksService = new MapBooksService();
        RandomIsbnGeneratorService isbnGeneratorService = new RandomIsbnGeneratorService();
        SimpleStoreService storeService = new SimpleStoreService();
        mapBooksService.setStoreService(storeService);
        mapBooksService.setIsbnGeneratorService(isbnGeneratorService);
        booksService = mapBooksService;

    }
    @Test public void doTestBooks() throws BookException{
        Book book1 = new Book("ISBN1", "Title1", 100, 19.99, true);
        booksService.newBook(book1);
        Book searchResult = booksService.findBookByIsbn(book1.getIsbn());
        Assertions.assertEquals(book1, searchResult);
        booksService.deleteBookByIsbn(book1.getIsbn());
    }
}
