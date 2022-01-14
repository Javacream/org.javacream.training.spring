package org.javacream.books.warehouse.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")

public class FindByMaxPriceTest {
    @Autowired private BooksService booksService;


    @Test
    public void testFindByMaxPrice20Finds2Books()  {
        Assertions.assertEquals(2, booksService.findByMaxPrice(20d).size());
    }
    @Test
    public void testFindByMaxPrice10Finds1Book()  {
        Assertions.assertEquals(1, booksService.findByMaxPrice(10d).size());
    }
}
