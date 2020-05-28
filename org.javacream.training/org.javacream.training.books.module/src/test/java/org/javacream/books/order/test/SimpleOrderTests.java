package org.javacream.books.order.test;

import org.javacream.books.order.impl.SimpleOrderService;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("prod")

public class SimpleOrderTests {

	@Autowired SimpleOrderService orderService;
	@Autowired StoreService storeService;
	@Autowired BooksService booksService;
	
	@Test public void testOrdering() throws Exception{
	
		String isbn = booksService.newBook("SPRING");
		System.out.println(storeService.getStock("books", isbn));
		System.out.println(orderService.order(isbn, 6));
//		System.out.println(orderService.order(isbn, 6));
	}
}
