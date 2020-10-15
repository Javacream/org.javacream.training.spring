package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.DatabaseStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest()
@ActiveProfiles("test")
public class BooksServiceTest {

	@Test
	public void testBusinessObjects() {
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGeneratorService randomIsbnGenerator = new RandomIsbnGeneratorService();
		randomIsbnGenerator.setCountryCode("-de");
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		mapBooksService.setStoreService(new DatabaseStoreService());
		randomIsbnGenerator.setPrefix("TEST:");

		TestActor.doTest(mapBooksService);

	}

	@Autowired
	BooksService booksService;

	@Test
	public void testSpring() {
		TestActor.doTest(booksService);

	}
	

}
