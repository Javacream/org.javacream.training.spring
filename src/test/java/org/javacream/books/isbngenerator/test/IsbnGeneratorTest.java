package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = IsbnGeneratorTest.IsbnGeneratorTestConfiguration.class)
@ActiveProfiles("test")
public class IsbnGeneratorTest {

	@RandomStrategy
	@Autowired private IsbnGenerator randomIsbnGenerator;
	@SequenceStrategy
	@Autowired private IsbnGenerator sequenceIsbnGenerator;
	
	@Test public void testRandomIsbnGenerator() {
		String isbn = randomIsbnGenerator.next();
		Assertions.assertTrue(isbn.startsWith("TEST-ISBN"));
	}
	@Test public void testSequenceIsbnGenerator() {
		String isbn = sequenceIsbnGenerator.next();
		Assertions.assertTrue(isbn.startsWith("TEST-ISBN"));
	}

	@SpringBootConfiguration
	@ComponentScan("org.javacream.books.isbngenerator")
	public static class IsbnGeneratorTestConfiguration{
		
	}

}
