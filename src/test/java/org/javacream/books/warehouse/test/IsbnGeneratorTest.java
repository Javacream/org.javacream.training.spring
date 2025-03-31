package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {
    @Autowired private IsbnGenerator counterIsbnGenerator;
    @Autowired private IsbnGenerator randomIsbnGenerator;

    @Test public void testIsbnGeneratorIsInjected(){
        Assertions.assertNotNull(counterIsbnGenerator);
        Assertions.assertNotNull(randomIsbnGenerator);
    }
}
