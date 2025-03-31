package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BooksServiceTest {

	@Autowired private BooksService booksService;
	@Autowired private IsbnGenerator isbnGenerator1;
	@Autowired private IsbnGenerator isbnGenerator2;
	@Autowired private IsbnGenerator isbnGenerator3;
	@Test
	public void testBusinessObjects() {
		TestActor.doTest(booksService);
	}
}
