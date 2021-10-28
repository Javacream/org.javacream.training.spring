package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.SequenceStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("prod")
public class IsbnGeneratorTests {

	@Autowired @RandomStrategy  IsbnGeneratorService ig1;
	@Autowired @SequenceStrategy  IsbnGeneratorService ig2;
	
	@Test public void dotest() {
		System.out.println("random: " + ig1.next() + " , ig=" + ig1);
		System.out.println("sequence: " + ig2.next());
	}
}