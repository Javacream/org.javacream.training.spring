package org.javacream.books.order.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")

public class FindOrderByIdTest {
    @Autowired private OrderService orderService;
    @Test public void findByOrderId1001FindsOrder(){
        Assertions.assertNotNull(orderService.findOrderById(1001l));
    }
    @Test public void findByOrderId4711FindsNull(){
        Assertions.assertNull(orderService.findOrderById(4711l));
    }
}
