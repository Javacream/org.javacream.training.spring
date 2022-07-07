package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.util.SpringTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringTest
public class BooksServiceTest {
    @Autowired
    private BooksService booksService;

    @Test
    public void contextLoads() {
        //
    }

    @Test
    public void testBooksService() {
        TestActor.doTest(booksService);
    }

    @Test
    public void booksServiceHas3InitialBooks() {
        Assertions.assertEquals(3, booksService.findAllBooks().size());
    }

    @Test
    public void searchForIsbn1RetrievesBookWithTitleTitle1() throws BookException {
        Assertions.assertEquals("Title1", booksService.findBookByIsbn("Isbn1").getTitle());
    }

    @Test
    public void searchForUnknownIsbnThrowsBookException() throws BookException {
        Assertions.assertThrows(BookException.class, () -> booksService.findBookByIsbn("UnknownIsbn"));
    }
}
