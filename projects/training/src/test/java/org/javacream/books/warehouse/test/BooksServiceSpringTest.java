package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class BooksServiceSpringTest {

	@Autowired @Qualifier("decorated") private BooksService booksService;
	@Test public void springWorks() {
		
	}

	@Test public void testBooksService() {
		TestActor.doTest(booksService);
	}

}
