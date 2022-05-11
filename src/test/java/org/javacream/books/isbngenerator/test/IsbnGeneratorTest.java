package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTest {

	@Autowired @SequenceStrategy private IsbnGenerator sequenceIsbnGenerator;
	@Autowired @RandomStrategy private IsbnGenerator randomIsbnGenerator;
	
	@Test public void randomIsbnGeneratorCreatesUniqueIsbn() {
		String isbn1 = randomIsbnGenerator.next();
		String isbn2 = randomIsbnGenerator.next();
		Assertions.assertNotEquals(isbn1, isbn2);
	}
	@Test public void sequenceIsbnGeneratorCreatesUniqueIsbn() {
		String isbn1 = sequenceIsbnGenerator.next();
		String isbn2 = sequenceIsbnGenerator.next();
		Assertions.assertNotEquals(isbn1, isbn2);
	}
}
