package org.javacream.books.isbngenerator.api;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SequenceNextTest {
    private final String PREFIX = "ISBN:";
    private final String COUNTRY_CODE = "-dk";
    @Autowired  private IsbnGeneratorService sequenceIsbnGeneratorService;

    @Test public void isbngeneratorGeneratesIsbn(){
        String isbn = sequenceIsbnGeneratorService.next();
        Assertions.assertNotNull(isbn);
    }
    @Test public void isbngeneratorGeneratesuniqueIsbns(){
        String isbn1 = sequenceIsbnGeneratorService.next();
        String isbn2 = sequenceIsbnGeneratorService.next();
        Assertions.assertNotEquals(isbn1, isbn2);
    }
    @Test public void generatedIsbnStartsWithPrefix(){
        String isbn = sequenceIsbnGeneratorService.next();
        Assertions.assertTrue(isbn.startsWith(PREFIX));
        Assertions.assertTrue(isbn.endsWith(COUNTRY_CODE));
    }
}
