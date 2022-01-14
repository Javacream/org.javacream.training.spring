package org.javacream.books.warehouse.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")

public class FindAvailableTest {
    @Autowired private BooksService booksService;


    @Test
    public void testFindAvailableFinds2Books() {
        Assertions.assertEquals(2, booksService.findAvailable().size());
    }
    @Test
    public void testFindByPriceRange5to30Finds3Books() {
        Assertions.assertEquals(3, booksService.findByPriceRange(5d, 30d).size());
    }
}
