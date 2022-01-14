package org.javacream.books.warehouse.api;

import org.javacream.books.isbngenerator.impl.SequenceIsbnGeneratorService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

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
