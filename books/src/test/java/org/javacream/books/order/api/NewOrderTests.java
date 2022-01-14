package org.javacream.books.order.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NewOrderTests {
    @Autowired private OrderService orderService;

    @Test public void order40Isbn1CreatesOkOrder(){
        Order order = orderService.order("Isbn1", 40, "tester");
        Assertions.assertEquals(Order.OrderStatus.OK, order.getStatus());
    }
    @Test public void order50Isbn1CreatesPendingOrder(){
        Order order = orderService.order("Isbn1", 50, "tester");
        Assertions.assertEquals(Order.OrderStatus.PENDING, order.getStatus());
    }
    @Test public void order50UnknownIsbnCreatesUnavailableOrder(){
        Order order = orderService.order("UnknownIsbn", 50, "tester");
        Assertions.assertEquals(Order.OrderStatus.UNAVAILABLE, order.getStatus());
    }

}
