package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {
    @Autowired private CounterIsbnGenerator isbnGenerator;

    @Test public void testIsbnGeneratorIsInjected(){
        Assertions.assertNotNull(isbnGenerator);
    }
}
