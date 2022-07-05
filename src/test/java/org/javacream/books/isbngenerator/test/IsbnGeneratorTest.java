package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class IsbnGeneratorTest {
    @Resource(name = "cig")
    private IsbnGenerator counterIsbnGenerator;
    @Resource(name = "randomIsbnGenerator")
    private IsbnGenerator randomIsbnGenerator;

    @Test public void testIsbnGenerator(){
        System.out.println(counterIsbnGenerator.next());
        System.out.println(randomIsbnGenerator.next());
    }
}

