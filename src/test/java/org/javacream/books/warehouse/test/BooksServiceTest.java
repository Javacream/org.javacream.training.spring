package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = BooksServiceTestConfiguration.class)
@ActiveProfiles("test")
public class BooksServiceTest {

	@Autowired private BooksService booksService;
	@Test
	public void testBusinessObjects() {
		TestActor.doTest(booksService);
	}

	@Test
	public void testFindBookInTestData() throws BookException {
		Assertions.assertEquals("Title1", booksService.findBookByIsbn("ISBN1").getTitle());
	}
	

}
