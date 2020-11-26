package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.SequenceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorTests {
	@Autowired @SequenceStrategy IsbnGeneratorService ig1;
	@Autowired @RandomStrategy IsbnGeneratorService ig2;
	

}
