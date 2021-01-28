package org.javacream.books.order.web;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderWebService {
    @Autowired private OrderService orderService;

    @GetMapping(path = "api/order/{isbn}/{number}", produces = "text/plain") public String createOrder(@PathVariable("isbn") String isbn, @PathVariable("number") int number){
        Order order = orderService.order(isbn, number);
        return order.toString();

    }

    @GetMapping(path = "api/order/{isbn}/{number}", produces = "application/json") public Order createOrderAsJson(@PathVariable("isbn") String isbn, @PathVariable("number") int number){
        Order order = orderService.order(isbn, number);
        return order;

    }
    @GetMapping(path = "api/order/{isbn}/{number}", produces = "application/xml") public Order createOrderAsXml(@PathVariable("isbn") String isbn, @PathVariable("number") int number){
        Order order = orderService.order(isbn, number);
        return order;

    }
}
