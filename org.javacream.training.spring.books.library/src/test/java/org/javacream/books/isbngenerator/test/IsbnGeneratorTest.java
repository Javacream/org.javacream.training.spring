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
    private IsbnGenerator random;
    @Autowired @IsbnGenerator.SequenceStrategy
    private IsbnGenerator counter;
    @Autowired @IsbnGenerator.SequenceStrategy
    private IsbnGenerator counter2;

    @Test
    public void simple(){
        System.out.println("Random:" + random);
        System.out.println("Counter:" + counter);
        System.out.println("Counter:" + counter2);
        System.out.println("==: " + (counter == counter2));

    }

}

