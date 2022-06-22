package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class BooksServiceSpringTest {

	@Autowired private BooksService booksService;
	@Test
	public void testSpring() {
		TestActor.doTest(booksService);
	}
	

	

}
