package org.javacream.books.warehouse.test;

import java.util.HashMap;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.books.warehouse.impl.JpaBooksService;
import org.javacream.store.impl.DatabaseStoreService;
import org.junit.jupiter.api.Test;


public class BooksServiceTest {

	@Test
	public void testBusinessObjects() {
		JpaBooksService mapBooksService = new JpaBooksService();
		RandomIsbnGeneratorService randomIsbnGenerator = new RandomIsbnGeneratorService();
		randomIsbnGenerator.setCountryCode("-de");
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		mapBooksService.setStoreService(new DatabaseStoreService());
		randomIsbnGenerator.setPrefix("TEST:");
		mapBooksService.setBooks(new HashMap<>());
		TestActor.doTest(mapBooksService);
	}
	

	

}
