package org.javacream.books.warehouse.test;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootConfiguration
@ComponentScan("org.javacream")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BooksServiceTestConfiguration {

	@Bean @Qualifier("booksMap") Map<String, Book>  books(){
		HashMap<String, Book> testData = new HashMap<>();
		Book b1 = new Book();
		b1.setIsbn("ISBN1");
		b1.setTitle("Title1");
		b1.setPrice(19.99);
		testData.put(b1.getIsbn(), b1);
		Book b2 = new Book();
		b2.setIsbn("ISBN2");
		b2.setTitle("Title2");
		b2.setPrice(1.99);
		testData.put(b2.getIsbn(), b2);
		return testData;
	}
}
