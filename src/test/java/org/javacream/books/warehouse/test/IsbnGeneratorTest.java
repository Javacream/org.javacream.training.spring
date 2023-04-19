package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {
    @Autowired
    IsbnGenerator cig;
    @Autowired
    IsbnGenerator randomIsbnGenerator;

    @Test public void testGenerators(){
        //Assertions.assertSame(isbnGenerator1, isbnGenerator2);//Default Scope = singleton
    }

}
