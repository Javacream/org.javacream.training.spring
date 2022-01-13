package org.javacream.training.books.warehouse.api;

import org.javacream.training.books.warehouse.impl.MapBooksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindByMinPriceTest {
    private BooksService booksService;

    @BeforeEach
    public void init() throws BookException {
        booksService = new MapBooksService();
        Book book1 = new Book("ISBN1", "Title1", 200, 19.99, true);
        Book book2 = new Book("ISBN2", "Title1", 200, 9.99, true);
        Book book3 = new Book("ISBN3", "Title1", 200, 29.99, true);
        booksService.newBook(book1);
        booksService.newBook(book2);
        booksService.newBook(book3);
    }

    @Test
    public void testFindByMinPrice20Finds1Book() throws BookException {
        Assertions.assertEquals(1, booksService.findByMinPrice(20d).size());
    }
    @Test
    public void testFindByMinPrice10Finds2Books() throws BookException {
        Assertions.assertEquals(2, booksService.findByMinPrice(10d).size());
    }
}
