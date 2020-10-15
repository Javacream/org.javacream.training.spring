package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.JpaBooksService;
import org.javacream.store.impl.DatabaseStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest()
@ActiveProfiles("test")
public class BooksServiceTest {

	//@Test //Nicht lauffähig ohne Dependency Injection!
	public void testBusinessObjects() {
		JpaBooksService mapBooksService = new JpaBooksService();
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
