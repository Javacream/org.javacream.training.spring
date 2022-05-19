package org.javacream.books.order.test;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
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
	
	@Test
	public void findOrderBy1000FindsOKOrder() {
		Order order = orderService.findOrderById(1000l);
		Assertions.assertEquals(OrderStatus.OK, order.getStatus());
	}
	@Test
	public void findOrderBy1001FindsPendingOrder() {
		Order order = orderService.findOrderById(1001l);
		Assertions.assertEquals(OrderStatus.PENDING, order.getStatus());
	}
	@Test
	public void findOrderBy1002FindsUnavailableOrder() {
		Order order = orderService.findOrderById(1002l);
		Assertions.assertEquals(OrderStatus.UNAVAILABLE, order.getStatus());
	}
	@Test
	public void findOrderBy42FindsNoOrder() {
		Order order = orderService.findOrderById(42l);
		Assertions.assertNull(order);
	}


}