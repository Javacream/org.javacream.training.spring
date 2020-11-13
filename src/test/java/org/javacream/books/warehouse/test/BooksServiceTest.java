package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.Test;


public class BooksServiceTest {

	@Test
	public void testBusinessObjects() {
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGeneratorService randomIsbnGenerator = new RandomIsbnGeneratorService();
		randomIsbnGenerator.setCountryCode("-de");
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		mapBooksService.setStoreService(new SimpleStoreService());
		randomIsbnGenerator.setPrefix("TEST:");
		
		TestActor.doTest(mapBooksService);
		
	
	}

	

}
