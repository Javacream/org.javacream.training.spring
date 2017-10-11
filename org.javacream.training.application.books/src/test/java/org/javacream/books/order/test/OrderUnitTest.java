package org.javacream.books.order.test;

import static org.mockito.BDDMockito.given;

import org.javacream.JavacreamApplication;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.impl.JpaOrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
@Import(OrderUnitTest.OrderTestConfiguration.class)
public class OrderUnitTest {
	private static final String TEST_ISBN = "ISBN-1";
	private static final String TEST_TITLE = "Title-1";
	private static final Double TEST_PRICE = 19.99;
	@Autowired
	private OrderService orderService;
	@MockBean
	private BooksService booksService;
	@MockBean
	private StoreService storeService;

	@Test
	public void testOrderService() throws Exception {

		given(booksService.findBookByIsbn(TEST_ISBN)).willReturn(new Book(TEST_ISBN, TEST_TITLE, TEST_PRICE, true));
		given(storeService.getStock("books", TEST_ISBN)).willReturn(3);
		System.out.println(orderService.createOrder(TEST_ISBN, 5));
	}

	@Configuration
	@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = JavacreamApplication.class))
	public static class OrderTestConfiguration {
		@Bean
		OrderService orderService() {
			return new JpaOrderService();
		}
	}
}
