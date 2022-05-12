package org.javacream.books.warehouse.test;

import org.javacream.JavacreamTest;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


@JavacreamTest
public class BooksServiceSpringTest {

	@Autowired private BooksService booksService;
	@Test
	public void testBusinessObjects() {

		TestActor.doTest(booksService);
		
	
	}

	

}
