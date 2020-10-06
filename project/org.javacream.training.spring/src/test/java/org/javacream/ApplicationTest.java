package org.javacream;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest {

	@Autowired
	private SimpleStoreService simpleStoreService;
	@Autowired @Qualifier("actor1")
	private StoreService storeService;
	@Autowired @IsbnGeneratorService.RandomStrategy
	private IsbnGeneratorService isbnGenerator;

	@Test
	void storeService() {
		int result = storeService.getStock("book", "ISBN");
		Assertions.assertEquals(42, result);
	}

	@Test
	void isbGenerator() {
//...	
		isbnGenerator.next();
	}

	@Test
	void contextLoads() {
		Assertions.assertNotNull(simpleStoreService);
		Assertions.assertNotNull(storeService);
		Assertions.assertTrue(simpleStoreService == storeService);
	}
}
