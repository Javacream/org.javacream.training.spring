package org.javacream.books.order;

import org.javacream.books.order.api.Order;
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
    @Test public void testOrderOk(){
        final int NUMBER = 40;
        Order order = orderService.order("TEST-ISBN", NUMBER);
        Assertions.assertTrue(order.getStatus() == OrderStatus.OK);
        Assertions.assertEquals(NUMBER*9.99, order.getTotalPrice(), 1e-9);

    }
    @Test public void testOrderPending(){
        final int NUMBER = 50;
        Order order = orderService.order("TEST-ISBN", NUMBER);
        Assertions.assertTrue(order.getStatus() == OrderStatus.PENDING);
        Assertions.assertEquals(NUMBER*9.99, order.getTotalPrice(), 1e-9);

    }
    @Test public void testOrderUnavailable(){
        final int NUMBER = 50;
        Order order = orderService.order("&!%TEST-ISBN", NUMBER);
        Assertions.assertTrue(order.getStatus() == OrderStatus.UNAVAILABLE);
        Assertions.assertEquals(0, order.getTotalPrice(), 1e-9);

    }
}
