package org.javacream.training.books.warehouse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FindAllIsbnsTest {
    private BooksService booksService;

    @BeforeEach
    public void init() throws BookException {
        booksService = new BooksService();
        Book book1 = new Book("ISBN1", "Title1", 200, 19.99, true);
        Book book2 = new Book("ISBN2", "Title1", 200, 19.99, true);
        Book book3 = new Book("ISBN3", "Title1", 200, 19.99, true);
        booksService.newBook(book1);
        booksService.newBook(book2);
        booksService.newBook(book3);
    }

    @Test
    public void testFindAllBooksFindsThreeIsbns() throws BookException {
        Assertions.assertEquals(3, booksService.findAllIsbns().size());
    }
}
