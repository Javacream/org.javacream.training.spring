package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@ActiveProfiles("dev")
public class IsbnGeneratorTest {
	@Autowired @RandomStrategy private IsbnGenerator isbnGenerator1;
	@Autowired @SequenceStrategy private IsbnGenerator isbnGenerator2;
	
	
	@Test public void testGenerators() {
		System.out.println(isbnGenerator1);
		System.out.println(isbnGenerator2);

	}
	
}
