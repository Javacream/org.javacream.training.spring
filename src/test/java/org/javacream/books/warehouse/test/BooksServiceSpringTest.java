package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BooksServiceSpringTest {

	private @Autowired BooksService booksService;
	
	@Test public void testBooksService() {
		TestActor.doTest(booksService);
	}
	
	@SpringBootConfiguration 
	@EnableAspectJAutoProxy(proxyTargetClass = true)
	@ComponentScan(basePackages= {"org.javacream.books", "org.javacream.store", "org.javacream.util.aspects"})
	public static class BooksServiceTestConfiguration{
		
	}
}
