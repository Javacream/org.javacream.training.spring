package org.javacream.books.warehouse.test;

import org.javacream.TrainingApplication;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TrainingApplication.class)
public class BooksServiceSpringTest {

	@Autowired private BooksService booksService;
	@Test public void springWorks() {
		
	}

	@Test public void testBooksService() {
		TestActor.doTest(booksService);
	}

}
