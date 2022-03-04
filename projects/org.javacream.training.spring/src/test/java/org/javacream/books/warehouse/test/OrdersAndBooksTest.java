package org.javacream.books.warehouse.test;

import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class OrdersAndBooksTest {
	@Autowired BooksService booksService;
	@Autowired OrderService orderService;
	@Test public void testOrdersAndBooks() throws BookException {
		System.out.println(orderService.order("irgendwas", 5).getOrderId());
		System.out.println(booksService.newBook("irgendwas"));
		System.out.println(booksService.newBook("irgendwas"));
		System.out.println(orderService.order("irgendwas", 5).getOrderId());
		System.out.println(booksService.newBook("irgendwas"));
	}
}
