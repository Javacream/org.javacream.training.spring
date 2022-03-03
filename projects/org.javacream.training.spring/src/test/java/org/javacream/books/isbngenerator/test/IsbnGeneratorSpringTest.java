package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorSpringTest {

	@Autowired IsbnGenerator isbnGenerator1;
	@Autowired IsbnGenerator isbnGenerator2;
	@Autowired BooksService booksService;
	
	@Test public void howMany() {
		System.out.println(isbnGenerator1 == isbnGenerator2);
	}
}
