package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = RandomIsbnGeneratorTest.IsbnGeneratorTestConfiguration.class)
@ActiveProfiles("test")
@EntityScan("org.javacream")
public class RandomIsbnGeneratorTest {

	@Autowired private RandomIsbnGeneratorService isbnGenerator;
	
	@Test public void testIsbnGenerator() {
		String isbn = isbnGenerator.next();
		Assertions.assertTrue(isbn.startsWith("TEST-ISBN"));
	}

	@SpringBootConfiguration
	@EnableAutoConfiguration
	@ComponentScan("org.javacream.books.isbngenerator")
	public static class IsbnGeneratorTestConfiguration{
		
	}

}
