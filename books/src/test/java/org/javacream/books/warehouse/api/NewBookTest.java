package org.javacream.books.warehouse.api;

import org.javacream.books.isbngenerator.impl.SequenceIsbnGeneratorService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewBookTest {
    private BooksService booksService;

    @BeforeEach
    public void init() throws BookException {
        //TODO: Das ist noch nicht schön -> Spring
        MapBooksService mapBooksService = new MapBooksService();
        SequenceIsbnGeneratorService isbnGeneratorService = new SequenceIsbnGeneratorService();
        mapBooksService.setIsbnGeneratorService(isbnGeneratorService);
        booksService = mapBooksService;
    }

    @Test
    public void testNewBookWorks() throws BookException {
        String generatedIsbn = booksService.newBook("TEST", 19.99, 100);
        System.out.println(generatedIsbn);
        Assertions.assertNotNull(generatedIsbn);
    }
}
