package org.javacream.books.warehouse.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")

public class FindBookByTitleTest {
    @Autowired private BooksService booksService;
    private Book book;


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
