package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {
    @Autowired
    IsbnGenerator isbnGenerator;
    @Autowired
    IsbnGenerator isbnGenerator2;

    @Test public void testIsbngenerator(){
        System.out.println(isbnGenerator);
        System.out.println(isbnGenerator2);
        Assertions.assertTrue(isbnGenerator == isbnGenerator2);

    }
}
