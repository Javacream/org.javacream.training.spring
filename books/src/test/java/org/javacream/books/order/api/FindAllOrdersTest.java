package org.javacream.books.order.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FindAllOrdersTest {
    @Autowired private OrderService orderService;
    @Test public void allOrdersAreNeverNull(){
        Assertions.assertNotNull(orderService.allOrders());
    }
}
