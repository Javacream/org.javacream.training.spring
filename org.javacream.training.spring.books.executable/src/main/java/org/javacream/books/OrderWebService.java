package org.javacream.books;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderWebService {
    @PostMapping(path="api/orders/{isbn}/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order order(@PathVariable("isbn") String isbn, @PathVariable("number")int number) {
        return orderService.order(isbn, number);
    }

    @GetMapping(path = "api/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order findOrderById(@PathVariable("id")long orderId) {
        return orderService.findOrderById(orderId);
    }

    @Autowired private OrderService orderService;


}
