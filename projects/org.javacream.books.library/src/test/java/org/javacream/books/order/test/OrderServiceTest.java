package org.javacream.books.order.test;

import org.javacream.books.order.api.OrderEntity;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.api.OrderStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class OrderServiceTest {
	@Autowired private OrderService orderService;
	@Test public void testOrderWithISBN1andNumber10isOk() {
		OrderEntity order = orderService.order("ISBN1", 10);
		Assertions.assertTrue(OrderStatus.OK == order.getStatus());
		
	}
	@Test public void testOrderWithISBN1andNumber100isPending() {
		OrderEntity order = orderService.order("ISBN1", 100);
		Assertions.assertTrue(OrderStatus.PENDING == order.getStatus());
		
	}
	@Test public void testOrderWithISBNXYZisUnavailable() {
		OrderEntity order = orderService.order("ISBNXYZ", 100);
		Assertions.assertTrue(OrderStatus.UNAVAILABLE == order.getStatus());
		
	}

}
