package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.Test;


public class BooksServiceTest {

	@Test
	public void testBusinessObjects() {
		SimpleStoreService storeService = new SimpleStoreService();
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		randomIsbnGenerator.setCountryCode("-de");
		mapBooksService.setStoreService(storeService);
		randomIsbnGenerator.setPrefix("TEST:");
		storeService.setStock(42);
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		
		TestActor.doTest(mapBooksService);
		
	
	}

	

}
