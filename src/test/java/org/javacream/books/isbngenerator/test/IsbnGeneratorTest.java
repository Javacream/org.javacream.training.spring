package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class IsbnGeneratorTest {
    @Autowired @IsbnGenerator.RandomStrategy
    private IsbnGenerator isbnGenerator1;
    @Autowired @IsbnGenerator.RandomStrategy
    private IsbnGenerator isbnGenerator2;
    @Autowired @IsbnGenerator.SequenceStrategy
    private IsbnGenerator isbnGenerator3;
    @Autowired @IsbnGenerator.SequenceStrategy
    private IsbnGenerator isbnGenerator4;

    @Test public void testIsbnGenerator(){
        System.out.println(isbnGenerator1.next());
        System.out.println(isbnGenerator2.next());
        System.out.println(isbnGenerator3.next());
        System.out.println(isbnGenerator4.next());
        System.out.println("isbngenerator1 == isbngenerator2: " + (isbnGenerator1 == isbnGenerator2));
        System.out.println("isbngenerator3 == isbngenerator4: " + (isbnGenerator3 == isbnGenerator4));
    }
}

