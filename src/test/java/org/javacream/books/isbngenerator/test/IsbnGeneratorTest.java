package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class IsbnGeneratorTest {
    @Autowired @IsbnGenerator.RandomStrategy
    private IsbnGenerator isbnGenerator;
    @Value("${isbngenerator.prefix}") private String expectedPrefix;
    @Value("${isbngenerator.countryCode}") private String expectedCountrycode;

    @Test public void testPrefix(){
        Assertions.assertTrue(isbnGenerator.next().startsWith(expectedPrefix));
    }
    @Test public void testCountryCode(){
        Assertions.assertTrue(isbnGenerator.next().endsWith(expectedCountrycode));
    }
}
