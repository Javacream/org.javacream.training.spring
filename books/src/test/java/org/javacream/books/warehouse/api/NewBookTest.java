package org.javacream.books.warehouse.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NewBookTest {
    @Autowired
    private BooksService booksService;


    @Test
    public void testNewBookWorks() throws BookException {
        String generatedIsbn = booksService.newBook("TEST", 19.99, 100);
        System.out.println(generatedIsbn);
        Assertions.assertNotNull(generatedIsbn);
        booksService.deleteBookByIsbn(generatedIsbn);
    }
}
