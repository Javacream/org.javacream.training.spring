package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CounterIsbnGeneratorTest {
	@Autowired private CounterIsbnGenerator counterIsbnGenerator1;
	@Autowired private CounterIsbnGenerator counterIsbnGenerator2;
	@Autowired private BooksService booksService;
	//private CounterIsbnGenerator counterIsbnGenerator3 = new CounterIsbnGenerator();
	
	@Test public void doTest() {
		System.out.println(counterIsbnGenerator1.next());
		System.out.println(counterIsbnGenerator1.next());
		System.out.println(counterIsbnGenerator2.next());
		System.out.println(counterIsbnGenerator1.next());
//		System.out.println(counterIsbnGenerator3.next());
		counterIsbnGenerator1.setPrefix("Hugfo");
		System.out.println(counterIsbnGenerator2.next());

	}
}
