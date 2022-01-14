package org.javacream.books.warehouse.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FindByPriceRangeTest {
@Autowired
private BooksService booksService;


    @Test
    public void testFindByPriceRange10to20Finds1Book() {
        Assertions.assertEquals(1, booksService.findByPriceRange(10d, 20d).size());
    }
    @Test
    public void testFindByPriceRange5to30Finds3Books() {
        Assertions.assertEquals(3, booksService.findByPriceRange(5d, 30d).size());
    }
}
