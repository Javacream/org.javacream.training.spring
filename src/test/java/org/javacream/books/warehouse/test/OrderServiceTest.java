package org.javacream.books.warehouse.test;

import org.javacream.books.order.Order;
import org.javacream.books.order.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class OrderServiceTest {
    @Autowired private OrderService orderService;

    @Test public void order40Isbn1CreatesOkOrder(){
        Long id = orderService.order("ISBN1", 40);
        Order order = orderService.findById(id);
        Assertions.assertEquals(Order.OrderStatus.OK, order.status());
    }
    @Test public void order50Isbn1CreatesPendingOrder(){
        Long id = orderService.order("ISBN1", 50);
        Order order = orderService.findById(id);
        Assertions.assertEquals(Order.OrderStatus.PENDING, order.status());
    }
    @Test public void order50UnknownIsbnCreatesUnavailableOrder(){
        Long id = orderService.order("XYZ", 50);
        Order order = orderService.findById(id);
        Assertions.assertEquals(Order.OrderStatus.UNAVAILABLE, order.status());
    }

}
