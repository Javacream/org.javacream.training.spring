package org.javacream.books.order.api.test;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {
	@Autowired OrderService orderService;
	@Test public void orderIsCreated() {
		Order order = orderService.order("ISBN1", 10);
		Assertions.assertNotNull(order);
	}

	@Test public void ordersAreNotNull() {
		Assertions.assertNotNull(orderService.allOrders());
	}

	@Test public void createAnOrderIncreasesOrdersSizeByOne() {
		int startSize = orderService.allOrders().size();
		orderService.order("ISBN1", 10);		
		int endSize = orderService.allOrders().size();
		Assertions.assertEquals((startSize + 1), endSize);
	}

}
