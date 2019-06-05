package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.junit.Test;


public class BooksServiceTest {

	@Test
	public void testBusinessObjects() {
		StoreService storeService = new StoreService() {

			@Override
			public int getStock(String category, String item) {
				return 0;
			}
			
		};
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		randomIsbnGenerator.setCountryCode("-de");
		mapBooksService.setStoreService(storeService);
		randomIsbnGenerator.setPrefix("TEST:");
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		TestActor.doTest(mapBooksService);
		
	
	}

	

}
