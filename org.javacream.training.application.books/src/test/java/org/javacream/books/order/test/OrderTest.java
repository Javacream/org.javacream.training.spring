package org.javacream.books.order.test;

import java.util.HashMap;

import org.javacream.JavacreamApplication;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.impl.SimpleOrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles({ "test" })
@Import(OrderTest.OrderTestConfiguration.class)
public class OrderTest {
	private static final String TEST_ISBN = "ISBN-1";
	private static final String TEST_TITLE = "Title-1";
	private static final Double TEST_PRICE = 19.99;
	@Autowired
	private OrderService orderService;

	
	@Test
	public void testOrderService() {
		System.out.println(orderService.createOrder(TEST_ISBN, 5));

	}

	@Configuration
	@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = JavacreamApplication.class))
	public static class OrderTestConfiguration {
		@Bean
		OrderService orderService() {
			return new SimpleOrderService();
		}
		@Bean
		BooksService booksService() {
			MapBooksService mapBooksService = new MapBooksService();
			HashMap<String, Book> books = new HashMap<>();
			books.put(TEST_ISBN, new Book(TEST_ISBN, TEST_TITLE, TEST_PRICE, true));
			mapBooksService.setBooks(books);
			return mapBooksService;
		}
		@Bean
		IsbnGenerator isbnGenerator() {
			return new RandomIsbnGenerator();
		}
		@Bean
		StoreService storeService() {
			return new SimpleStoreService();
		}
	}
}
