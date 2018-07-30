package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/application.xml")
public class BooksServiceSpringTest {

	@Autowired
	private BooksService booksService;
	@Autowired
	private IsbnGenerator isbnGenerator;
	
	@Test public void doSpringTest() {
		TestActor.doTest(booksService);
		System.out.println(isbnGenerator.next());
	}
}
