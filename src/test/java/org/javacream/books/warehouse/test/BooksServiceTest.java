package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Test;


public class BooksServiceTest {

	@Test
	public void testBusinessObjects() {
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator("this", "that");
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		SimpleStoreService simpleStoreService = new SimpleStoreService();
		simpleStoreService.setStock(4711);
		mapBooksService.setStoreService(simpleStoreService);
		
		TestActor.doTest(mapBooksService);
		
	
	}

	

}
