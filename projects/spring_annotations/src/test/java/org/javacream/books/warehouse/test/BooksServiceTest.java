package org.javacream.books.warehouse.test;

import java.util.HashMap;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorImpl;
import org.javacream.books.warehouse.impl.MapBooksServiceImpl;
import org.javacream.store.impl.SimpleStoreServiceImpl;
import org.junit.jupiter.api.Test;


public class BooksServiceTest {

	@Test
	public void testBusinessObjects() {
		MapBooksServiceImpl mapBooksService = new MapBooksServiceImpl();
		RandomIsbnGeneratorImpl randomIsbnGenerator = new RandomIsbnGeneratorImpl();
		randomIsbnGenerator.setCountryCode("-de");
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		mapBooksService.setStoreService(new SimpleStoreServiceImpl());
		randomIsbnGenerator.setPrefix("TEST:");
		mapBooksService.setBooks(new HashMap<>());
		TestActor.doTest(mapBooksService);
		
	
	}

	

}
