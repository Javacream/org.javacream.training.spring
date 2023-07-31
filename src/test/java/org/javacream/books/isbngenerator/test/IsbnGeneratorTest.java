package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {
    @Autowired private RandomIsbnGenerator randomIsbnGenerator;
    @Autowired private CounterIsbnGenerator counterIsbnGenerator;
    @Autowired private IsbnGenerator rig;

    @Test
    public void simple(){
        System.out.println("Random:" + randomIsbnGenerator);
        System.out.println("Counter:" + counterIsbnGenerator);
        System.out.println("isbngenerator:" + rig);

    }

}

