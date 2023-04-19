package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {
    @Autowired
    @Qualifier("randomStrategy")
    IsbnGenerator ig1;

    @Autowired
    @Qualifier("sequenceStrategy")
    IsbnGenerator ig2;

    @Test public void testGenerators(){
        //Assertions.assertSame(isbnGenerator1, isbnGenerator2);//Default Scope = singleton
    }

}
