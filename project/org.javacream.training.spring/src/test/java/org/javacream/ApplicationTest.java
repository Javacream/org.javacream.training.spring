package org.javacream;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest {

	@Autowired
	private SimpleStoreService simpleStoreService;
	@Autowired
	private StoreService storeService;
	@Autowired @IsbnGenerator.RandomStrategy
	private IsbnGenerator isbnGenerator;

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
