package org.javacream.books.order.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"test"})
public class FindOrderTest {
    @Autowired private OrderService orderService;

    //@Test
    public void order1IsOk(){
        Order order = orderService.findOrderById(1l);
        Assertions.assertEquals(Order.OrderStatus.OK, order.getStatus());
    }
    //@Test
    public void order2IsPending(){
        Order order = orderService.findOrderById(2l);
        Assertions.assertEquals(Order.OrderStatus.PENDING, order.getStatus());
    }
    @Test public void order3IsUnavailable(){
        Order order = orderService.findOrderById(3l);
        Assertions.assertEquals(Order.OrderStatus.UNAVAILABLE, order.getStatus());
    }

}