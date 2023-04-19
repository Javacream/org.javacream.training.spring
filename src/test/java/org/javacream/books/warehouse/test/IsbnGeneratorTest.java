package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.RandomStrategy;
import org.javacream.books.isbngenerator.api.SequenceStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {
    @Autowired
    @SequenceStrategy
    IsbnGenerator ig1;

    @Autowired
    @RandomStrategy
    IsbnGenerator ig2;

    @Test public void testGenerators(){
        //Assertions.assertSame(isbnGenerator1, isbnGenerator2);//Default Scope = singleton
    }

}
