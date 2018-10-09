package org.javacream;

import org.javacream.books.warehouse.api.BooksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksWarehouseApplicationTests {
	@Autowired private BooksService booksService;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testBooksService() {
		TestActor.doTest(booksService);
	}

	
	
}
