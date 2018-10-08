package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BooksServiceSpringAnnotationsConfigurationTest {

	@Autowired
	private BooksService booksService;
	@Autowired
	private IsbnGenerator isbnGenerator;
	@Autowired
	private IsbnGenerator isbnGenerator2;

	@Test
	public void testBusinessObjects() {
		TestActor.doTest(booksService);
		Assert.assertTrue(isbnGenerator == isbnGenerator2);
		// GRÖBSTES HACKING: ((MapBooksService)booksService) NEVER AGAIN!!!!
		Assert.assertTrue(isbnGenerator == ((MapBooksService) booksService).getIsbnGenerator());

	}

	@Configuration
	@ComponentScan("org.javacream")
	@PropertySource("bookswarehouse.properties")
	public static class TestConfiguration {

	}
}
