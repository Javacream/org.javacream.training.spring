package org.javacream.books.order.test;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

	@Autowired
	OrderService orderService;

	@Test
	public void ordering10IsbnISBN1CreatesOKOrder() {
		Order order = orderService.order("ISBN1", 10);
		Assertions.assertEquals(OrderStatus.OK, order.getStatus());
	}
	@Test
	public void ordering50IsbnISBN1CreatesPendingOrder() {
		Order order = orderService.order("ISBN1", 50);
		Assertions.assertEquals(OrderStatus.PENDING, order.getStatus());
	}
	@Test
	public void orderingUnknownIsbnCreatesUnavailableOrder() {
		Order order = orderService.order("asdfghjk", 50);
		Assertions.assertEquals(OrderStatus.UNAVAILABLE, order.getStatus());
	}
}
