package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorSpringTest {

	@Autowired RandomIsbnGenerator isbnGenerator1;
	@Autowired RandomIsbnGenerator isbnGenerator2;
	@Autowired BooksService booksService;
	
	@Test public void howMany() {
		System.out.println(isbnGenerator1 == isbnGenerator2);
	}
}
