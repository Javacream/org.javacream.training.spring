package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = TestConfiguration.class)
@SpringBootTest
public class BooksServiceSpringTest {

	@Autowired private BooksService booksService;
	@Test
	public void testSpring() {
		TestActor.doTest(booksService);
	}
	

	

}
