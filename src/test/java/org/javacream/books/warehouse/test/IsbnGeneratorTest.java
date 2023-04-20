package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")

public class IsbnGeneratorTest {
    @Autowired
    @IsbnGenerator.SequenceStrategy
    IsbnGenerator ig1;

    @Autowired
    @IsbnGenerator.RandomStrategy
    IsbnGenerator ig2;

    @Test public void testGenerators(){
        //Assertions.assertSame(isbnGenerator1, isbnGenerator2);//Default Scope = singleton
    }

}
