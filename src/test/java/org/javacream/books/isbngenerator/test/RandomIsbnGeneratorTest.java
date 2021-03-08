package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = RandomIsbnGeneratorTest.IsbnGeneratorTestConfiguration.class)
@ActiveProfiles("test")
public class RandomIsbnGeneratorTest {

	@Autowired private IsbnGenerator isbnGenerator;
	
	@Test public void testIsbnGenerator() {
		String isbn = isbnGenerator.next();
		Assertions.assertTrue(isbn.startsWith("TEST-ISBN"));
	}

	@SpringBootConfiguration
	@ComponentScan("org.javacream.books.isbngenerator")
	public static class IsbnGeneratorTestConfiguration{
		
	}

}
