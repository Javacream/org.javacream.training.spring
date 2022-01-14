package org.javacream.books.order.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class FindAllOrdersTest {
    @Autowired private OrderService orderService;
    @Test public void allOrdersAreNeverNull(){
        Assertions.assertNotNull(orderService.allOrders());
    }
}
