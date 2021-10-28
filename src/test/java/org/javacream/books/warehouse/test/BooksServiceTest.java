package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.books.warehouse.impl.DatabaseBooksService;
import org.javacream.store.impl.DatabaseStoreService;
import org.junit.jupiter.api.Test;


public class BooksServiceTest {

	@Test
	public void testBusinessObjects() {
		DatabaseBooksService mapBooksService = new DatabaseBooksService();
		RandomIsbnGeneratorService randomIsbnGenerator = new RandomIsbnGeneratorService();
		randomIsbnGenerator.setCountryCode("-de");
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		mapBooksService.setStoreService(new DatabaseStoreService());
		randomIsbnGenerator.setPrefix("TEST:");
		
		TestActor.doTest(mapBooksService);
	}
	

	

}
