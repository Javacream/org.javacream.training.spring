package org.javacream.books.order.test;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.javacream.util.SpringTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void ordering10IsbnIsbn1CreatesOKOrder() {
        Order order = orderService.order("Isbn1", 10);
        Assertions.assertEquals(OrderStatus.OK, order.getStatus());
    }

    @Test
    public void ordering50IsbnISBN1CreatesPendingOrder() {
        Order order = orderService.order("Isbn1", 50);
        Assertions.assertEquals(OrderStatus.PENDING, order.getStatus());
    }

    @Test
    public void orderingUnknownIsbnCreatesUnavailableOrder() {
        Order order = orderService.order("asdfghjk", 50);
        Assertions.assertEquals(OrderStatus.UNAVAILABLE, order.getStatus());
    }

    @Test
    public void findOrderBy1FindsOKOrder() {
        Order order = orderService.findOrderById(1l);
        Assertions.assertEquals(OrderStatus.OK, order.getStatus());
    }

    @Test
    public void findOrderBy2FindsPendingOrder() {
        Order order = orderService.findOrderById(2l);
        Assertions.assertEquals(OrderStatus.PENDING, order.getStatus());
    }

    @Test
    public void findOrderBy3FindsUnavailableOrder() {
        Order order = orderService.findOrderById(3l);
        Assertions.assertEquals(OrderStatus.UNAVAILABLE, order.getStatus());
    }

    @Test
    public void findOrderBy42FindsNoOrder() {
        Order order = orderService.findOrderById(42l);
        Assertions.assertNull(order);
    }

}