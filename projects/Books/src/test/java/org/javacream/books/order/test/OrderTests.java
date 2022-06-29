package org.javacream.books.order.test;

import java.util.List;
import java.util.Optional;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class OrderTests {
	@Autowired OrderRepository orderRepository;
	@Test public void doTest() {
		
		Order o1 = new Order(1l, "ISBN1", 100, 999.99, OrderStatus.OK);
		Order o2 = new Order(2l, "ISBN2", 10, 99.99, OrderStatus.PENDING);
		Order o3 = new Order(3l, "ISBN3", 200, 899.99, OrderStatus.OK);
		Order o4 = new Order(4l, "ISBN4", 2, 9.99, OrderStatus.UNAVAILABLE);
		orderRepository.save(o1);
		orderRepository.save(o2);
		orderRepository.save(o3);
		orderRepository.save(o4);
		List<Order> orders = orderRepository.findAll();
		Assertions.assertEquals(4, orders.size());
		Optional<Order> optionalOrder = orderRepository.findById(2l);
		Assertions.assertTrue(optionalOrder.isPresent());
		
		
		
	}
	

}
