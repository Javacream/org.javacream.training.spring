package org.javacream.books.isbngenerator.api.test;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {

	@Value("${isbngenerator.prefix}") String configuredPrefix;
	@Value("${isbngenerator.countryCode}") String configuredCountryCode;
	@Autowired RandomIsbnGenerator isbnGenerator;
	
	@Test public void isbngeneratorCreatesIsbn() {
		Assertions.assertNotNull(isbnGenerator.next());
	}
	@Test public void generatedIsbnStartsWithConfiguredPrefix() {
		String isbn = isbnGenerator.next();
		Assertions.assertTrue(isbn.startsWith(configuredPrefix));
	}
	@Test public void generatedIsbnEndsWithConfiguredCountryCode() {
		String isbn = isbnGenerator.next();
		Assertions.assertTrue(isbn.endsWith(configuredCountryCode));
	}
	@Test public void generatedIsbnsAreUnique() {
		String isbn1 = isbnGenerator.next();
		String isbn2 = isbnGenerator.next();
		Assertions.assertNotEquals(isbn1, isbn2);
	}
}
