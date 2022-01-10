package org.javacream.training.books.warehouse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindBookByTitleTest {
    private BooksService booksService;
    private Book book;

    @BeforeEach public void init() throws BookException{
        booksService = new BooksService();
        book = new Book("ISBN1", "Title1", 200, 19.99, true);
        booksService.newBook(book);
    }

    @Test public void testFindBookByTitleTitle1Ok() throws BookException {
        Assertions.assertEquals(1, booksService.findByTitle("Title1").size());
    }
    @Test public void testFindBookByTitleXyzFindsEmptyList() throws BookException {
        Assertions.assertEquals(0, booksService.findByTitle("Xyz").size());
    }
    @Test public void testFindBookByTitleNullThrowsBookException() throws BookException {
        Assertions.assertThrows(BookException.class, () -> booksService.findByTitle(null));
    }
}
