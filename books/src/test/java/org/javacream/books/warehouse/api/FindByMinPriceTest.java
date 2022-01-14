package org.javacream.books.warehouse.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class FindByMinPriceTest {
@Autowired
private BooksService booksService;


    @Test
    public void testFindByMinPrice20Finds1Book(){
        Assertions.assertEquals(1, booksService.findByMinPrice(20d).size());
    }
    @Test
    public void testFindByMinPrice10Finds2Books() {
        Assertions.assertEquals(2, booksService.findByMinPrice(10d).size());
    }
}
