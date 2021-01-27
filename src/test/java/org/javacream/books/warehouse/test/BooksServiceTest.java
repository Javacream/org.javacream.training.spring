package org.javacream.books.warehouse.test;

import org.javacream.books.BooksTestDataConfiguration;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes= {BooksServiceTest.BooksTestConfiguration.class, BooksTestDataConfiguration.class})
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

    @Configuration
    @ComponentScan({"org.javacream.books.warehouse", "org.javacream.books.isbngenerator", "org.javacream.store"})
    public static class BooksTestConfiguration{

    }

}
