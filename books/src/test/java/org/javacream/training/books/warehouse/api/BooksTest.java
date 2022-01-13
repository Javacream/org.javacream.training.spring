package org.javacream.training.books.warehouse.api;

import org.javacream.training.books.warehouse.impl.MapBooksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BooksTest {
    private BooksService booksService;
    @BeforeEach
    public void init() throws BookException {
        booksService = new MapBooksService();
    }
    @Test public void doTestBooks() throws BookException{
        Book book1 = new Book("ISBN1", "Title1", 100, 19.99, true);
        booksService.newBook(book1);
        Book searchResult = booksService.findBookByIsbn(book1.getIsbn());
        Assertions.assertEquals(book1, searchResult);
        booksService.deleteBookByIsbn(book1.getIsbn());
    }
}
