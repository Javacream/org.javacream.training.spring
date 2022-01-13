package org.javacream.books.warehouse.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class FindAllIsbnsTest {
    @Autowired
    private BooksService booksService;


    @Test
    public void testFindAllBooksFindsThreeIsbns() throws BookException {
        Assertions.assertEquals(3, booksService.findAllIsbns().size());
    }
}
