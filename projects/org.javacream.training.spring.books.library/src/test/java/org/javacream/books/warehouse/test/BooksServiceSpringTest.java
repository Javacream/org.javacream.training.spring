package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BooksServiceSpringTest {

	private @Autowired BooksService booksService;
	
	@Test public void testBooksService() {
		TestActor.doTest(booksService);
	}
	
	@SpringBootApplication()
	@EnableJpaRepositories(basePackages = "org.javacream.books")
	@ComponentScan(basePackages= {"org.javacream.books", "org.javacream.store", "org.javacream.util.aspects"})
	@EntityScan(basePackages = "org.javacream")
	public static class BooksServiceTestConfiguration{
		
	}
}
