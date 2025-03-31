package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class IsbnGeneratorTest {
    @Autowired
    RandomIsbnGenerator isbnGenerator;
    @Autowired
    CounterIsbnGenerator isbnGenerator2;
    @Autowired @IsbnGenerator.RandomStrategy
    IsbnGenerator isbnGenerator3;
    @Autowired @IsbnGenerator.SequenceStrategy
    IsbnGenerator isbnGenerator4;

    @Test public void testIsbngenerator(){
        System.out.println(isbnGenerator);
        System.out.println(isbnGenerator2);
        System.out.println(isbnGenerator3);
        System.out.println(isbnGenerator4);
        Assertions.assertTrue(isbnGenerator == isbnGenerator3);
        Assertions.assertTrue(isbnGenerator2 == isbnGenerator4);

    }
}
