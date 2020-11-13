package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
public class BooksServiceSpringTest {

	private @Autowired BooksService booksService;
	
	@Test public void testBooksService() {
		TestActor.doTest(booksService);
	}
	
	@SpringBootConfiguration 
	@ComponentScan(basePackages= {"org.javacream.books", "org.javacream.store"})
	public static class BooksServiceTestConfiguration{
		
	}
}
