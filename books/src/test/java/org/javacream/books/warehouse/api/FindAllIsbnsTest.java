package org.javacream.books.warehouse.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
//@DirtiesContext

public class FindAllIsbnsTest {
    @Autowired
    private BooksService booksService;


    @Test
    public void testFindAllBooksFindsThreeIsbns() throws BookException {
        Assertions.assertEquals(3, booksService.findAllIsbns().size());
    }
}
