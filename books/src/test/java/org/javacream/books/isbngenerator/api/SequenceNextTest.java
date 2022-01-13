package org.javacream.books.isbngenerator.api;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.books.isbngenerator.impl.SequenceIsbnGeneratorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SequenceNextTest {
    private final String PREFIX = "Isbn:";
    private final String COUNTRY_CODE = "-dk";
    private IsbnGeneratorService isbngeneratorService;
    @BeforeEach public void setUp(){
        RandomIsbnGeneratorService randomIsbnGeneratorService = new RandomIsbnGeneratorService();
        randomIsbnGeneratorService.setPrefix(PREFIX);
        randomIsbnGeneratorService.setCountryCode(COUNTRY_CODE);
        isbngeneratorService = randomIsbnGeneratorService;
    }

    @Test public void isbngeneratorGeneratesIsbn(){
        String isbn = isbngeneratorService.next();
        Assertions.assertNotNull(isbn);
    }
    @Test public void isbngeneratorGeneratesuniqueIsbns(){
        String isbn1 = isbngeneratorService.next();
        String isbn2 = isbngeneratorService.next();
        Assertions.assertNotEquals(isbn1, isbn2);
    }
    @Test public void generatedIsbnStartsWithPrefix(){
        String isbn = isbngeneratorService.next();
        Assertions.assertTrue(isbn.startsWith(PREFIX));
        Assertions.assertTrue(isbn.endsWith(COUNTRY_CODE));
    }
}
