package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BooksServiceSpringTest {

	@Autowired private BooksService booksService;
	@Test
	public void testSpring() {
		TestActor.doTest(booksService);
	}
	

	

}
