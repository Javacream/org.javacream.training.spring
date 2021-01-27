package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BooksServiceTest {

    @Autowired private BooksService booksService;
    @Test
    public void contextLoads(){

    }

    @Test
    public void testBooksService(){
        TestActor.doTest(booksService);
    }


    //@Test
    public void testBooksService2(){
        TestActor.doTest(new MapBooksService());
    }

}
