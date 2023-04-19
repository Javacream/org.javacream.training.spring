package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {
    @Autowired
    CounterIsbnGenerator isbnGenerator1;
    @Autowired
    RandomIsbnGenerator isbnGenerator2;

    @Test public void testGenerators(){
        //Assertions.assertSame(isbnGenerator1, isbnGenerator2);//Default Scope = singleton
    }

}
