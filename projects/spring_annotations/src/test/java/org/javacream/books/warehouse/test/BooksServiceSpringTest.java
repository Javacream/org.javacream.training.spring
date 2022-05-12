package org.javacream.books.warehouse.test;

import org.javacream.JavacreamTest;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.BooksService.Cloning;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


@JavacreamTest
public class BooksServiceSpringTest {

	@Autowired @Cloning private BooksService booksService;
	@Test
	public void testBusinessObjects() {

		TestActor.doTest(booksService);
		
	
	}

	

}
