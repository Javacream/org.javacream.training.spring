package org.javacream.books.order.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FindOrderByCustomerTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void findOrdersByCustomer_meierFinds3Orders() {
        Assertions.assertEquals(3, orderService.findOrdersByCustomer("meier").size());
    }

    @Test
    public void findOrdersByCustomer_schneiderFinds1Order() {
        Assertions.assertEquals(1, orderService.findOrdersByCustomer("schneider").size());
    }
    @Test
    public void findOrdersByCustomer_unknownFindsNoOrders() {
        Assertions.assertEquals(0, orderService.findOrdersByCustomer("unknown").size());
    }

}