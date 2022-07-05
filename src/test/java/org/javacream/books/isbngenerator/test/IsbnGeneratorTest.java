package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {
    @Autowired private IsbnGenerator cig;
    @Autowired private IsbnGenerator randomIsbnGenerator;

    @Test public void testIsbnGenerator(){
        System.out.println(cig.next());
        System.out.println(randomIsbnGenerator.next());
    }
}

