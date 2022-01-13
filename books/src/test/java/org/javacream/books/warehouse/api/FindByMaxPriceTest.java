package org.javacream.books.warehouse.api;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class FindByMaxPriceTest {
    @Autowired private BooksService booksService;


    @Test
    public void testFindByMaxPrice20Finds2Books() throws BookException {
        Assertions.assertEquals(2, booksService.findByMaxPrice(20d).size());
    }
    @Test
    public void testFindByMaxPrice10Finds1Book() throws BookException {
        Assertions.assertEquals(1, booksService.findByMaxPrice(10d).size());
    }
}
