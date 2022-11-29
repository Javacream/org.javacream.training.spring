package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BooksServiceSpringTest {
	@Autowired private BooksService booksService;
	@Autowired String message;
	@Test
	public void testBusinessObjects() {
		System.out.println("############ " + message);
		TestActor.doTest(booksService);
		
	
	}

	

}
