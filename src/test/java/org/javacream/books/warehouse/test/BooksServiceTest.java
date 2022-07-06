package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.util.SpringTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringTest
public class BooksServiceTest {
    @Autowired private BooksService booksService;
    @Test public void contextLoads(){
        //
    }

    @Test
    public void testBooksService(){
        TestActor.doTest(booksService);
    }
    @Test
    public void booksServiceHas5InitialBooks(){
        Assertions.assertEquals(5, booksService.findAllBooks().size());
    }
    @Test
    public void searchForIsbn1RetrievesBookWithTitleTitle1() throws BookException {
        Assertions.assertEquals("Title1", booksService.findBookByIsbn("Isbn1").getTitle());
    }
    @Test
    public void searchForUnknownIsbnThrowsBookException() throws BookException {
        Assertions.assertThrows(BookException.class, () -> booksService.findBookByIsbn("Unknown"));
    }
}
