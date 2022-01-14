package org.javacream.books.order.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")

public class FindOrderByIsbnTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void findByIsbn1001Finds2Orders() {
        Assertions.assertEquals(2, orderService.findOrdersByIsbn("Isbn1001").size());
    }

    @Test
    public void findByIsbn1002Finds3Orders() {
        Assertions.assertEquals(3, orderService.findOrdersByIsbn("Isbn1002").size());
    }
    @Test
    public void findByIsbn2002FindsNoOrders() {
        Assertions.assertEquals(0, orderService.findOrdersByIsbn("Isbn2002").size());
    }

}