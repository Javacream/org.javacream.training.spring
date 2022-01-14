package org.javacream.books.isbngenerator.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RandomNextTest {
    @Autowired private IsbnGeneratorService randomIsbnGeneratorService;
    private final String PREFIX = "ISBN:";
    private final String COUNTRY_CODE = "-dk";

    @Test public void isbngeneratorGeneratesIsbn(){
        String isbn = randomIsbnGeneratorService.next();
        Assertions.assertNotNull(isbn);
    }
    @Test public void isbngeneratorGeneratesuniqueIsbns(){
        String isbn1 = randomIsbnGeneratorService.next();
        String isbn2 = randomIsbnGeneratorService.next();
        Assertions.assertNotEquals(isbn1, isbn2);
    }
    @Test public void generatedIsbnStartsWithPrefix(){
        String isbn = randomIsbnGeneratorService.next();
        Assertions.assertTrue(isbn.startsWith(PREFIX));
        Assertions.assertTrue(isbn.endsWith(COUNTRY_CODE));
    }
}
