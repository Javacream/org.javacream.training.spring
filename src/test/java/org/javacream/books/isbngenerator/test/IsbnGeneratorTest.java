package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {
    @Autowired @IsbnGenerator.RandomStrategy
    private IsbnGenerator random;
    @Autowired @IsbnGenerator.CounterStrategy
    private IsbnGenerator counter;

    @Test
    public void simple(){
        System.out.println("Random:" + random);
        System.out.println("Counter:" + counter);

    }

}

