package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.CounterStrategy;
import org.javacream.books.isbngenerator.impl.RandomStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {
    @Autowired @RandomStrategy private IsbnGenerator random;
    @Autowired @CounterStrategy private IsbnGenerator counter;

    @Test
    public void simple(){
        System.out.println("Random:" + random);
        System.out.println("Counter:" + counter);

    }

}

