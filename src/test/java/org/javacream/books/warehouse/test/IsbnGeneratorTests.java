package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("prod")
public class IsbnGeneratorTests {

	@Autowired @RandomStrategy  IsbnGenerator ig1;
	@Autowired @SequenceStrategy  IsbnGenerator ig2;
	
	@Test public void dotest() {
		System.out.println("random: " + ig1.next() + " , ig=" + ig1);
		System.out.println("sequence: " + ig2.next());
	}
}