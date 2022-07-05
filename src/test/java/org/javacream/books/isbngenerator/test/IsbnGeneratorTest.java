package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {
    @Autowired
    private IsbnGenerator isbnGenerator1;
    @Autowired
    private IsbnGenerator isbnGenerator2;

    @Test public void testIsbnGenerator(){
        System.out.println(isbnGenerator1.next());
        System.out.println(isbnGenerator2.next());
    }
}

