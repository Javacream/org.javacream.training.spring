package org.javacream.books.isbngenerator.api;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.books.isbngenerator.impl.SequenceIsbnGeneratorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SequenceNextTest {
    private IsbnGeneratorService isbngeneratorService;

    @BeforeEach public void setUp(){
        isbngeneratorService = new SequenceIsbnGeneratorService();
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
}
