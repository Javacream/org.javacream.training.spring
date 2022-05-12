package org.javacream.books.warehouse.test;

import java.util.HashMap;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Test;


public class BooksServiceTest {

	@Test
	public void testBusinessObjects() {
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		randomIsbnGenerator.setCountryCode("-de");
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		mapBooksService.setStoreService(new SimpleStoreService());
		randomIsbnGenerator.setPrefix("TEST:");
		mapBooksService.setBooks(new HashMap<>());
		TestActor.doTest(mapBooksService);
		
	
	}

	

}
