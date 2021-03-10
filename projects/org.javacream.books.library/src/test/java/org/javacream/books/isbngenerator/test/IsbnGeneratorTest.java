package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.SequenceStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = IsbnGeneratorTest.IsbnGeneratorTestConfiguration.class)
@ActiveProfiles("test")
public class IsbnGeneratorTest {

	@RandomStrategy
	@Autowired private IsbnGeneratorService randomIsbnGenerator;
	@SequenceStrategy
	@Autowired private IsbnGeneratorService sequenceIsbnGenerator;
	
	@Test public void testRandomIsbnGenerator() {
		String isbn = randomIsbnGenerator.next();
		Assertions.assertTrue(isbn.startsWith("TEST-ISBN"));
	}
	@Test public void testSequenceIsbnGenerator() {
		String isbn = sequenceIsbnGenerator.next();
		Assertions.assertTrue(isbn.startsWith("TEST-ISBN"));
	}

	@SpringBootConfiguration
	@EnableAutoConfiguration
	@ComponentScan("org.javacream.books.isbngenerator")
	@EntityScan("org.javacream")
	public static class IsbnGeneratorTestConfiguration{
		
	}

}
