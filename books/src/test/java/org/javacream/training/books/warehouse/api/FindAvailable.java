package org.javacream.training.books.warehouse.api;

import org.javacream.training.books.warehouse.impl.MapBooksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindAvailable {
    private BooksService booksService;

    @BeforeEach
    public void init() throws BookException {
        booksService = new MapBooksService();
        Book book1 = new Book("Isbn1", "Title1", 200, 19.99, true);
        Book book2 = new Book("Isbn2", "Title1", 200, 9.99, false);
        Book book3 = new Book("Isbn3", "Title1", 200, 29.99, true);
        booksService.newBook(book1);
        booksService.newBook(book2);
        booksService.newBook(book3);
    }

    @Test
    public void testFindAvailableFinds2Books() throws BookException {
        Assertions.assertEquals(2, booksService.findAvailable().size());
    }
    @Test
    public void testFindByPriceRange5to30Finds3Books() throws BookException {
        Assertions.assertEquals(3, booksService.findByPriceRange(5d, 30d).size());
    }
}
