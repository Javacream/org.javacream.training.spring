package org.javacream.training.books.warehouse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindByPriceRange {
    private BooksService booksService;

    @BeforeEach
    public void init() throws BookException {
        booksService = new BooksService();
        Book book1 = new Book("ISBN1", "Title1", 200, 19.99, true);
        Book book2 = new Book("ISBN2", "Title1", 200, 9.99, true);
        Book book3 = new Book("ISBN3", "Title1", 200, 29.99, true);
        booksService.newBook(book1);
        booksService.newBook(book2);
        booksService.newBook(book3);
    }

    @Test
    public void testFindByPriceRange10to20Finds1Book() throws BookException {
        Assertions.assertEquals(1, booksService.findByPriceRange(10d, 20d).size());
    }
    @Test
    public void testFindByPriceRange5to30Finds3Books() throws BookException {
        Assertions.assertEquals(3, booksService.findByPriceRange(5d, 30d).size());
    }
}
