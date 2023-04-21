package org.javacream.books.order.web;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class OrderWebService {

    @PostMapping(path = "api/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order order(@RequestHeader("isbn") String isbn, @RequestHeader("number") int number) {
        return orderService.order(isbn, number);
    }

    @GetMapping(path = "api/order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order findOrderById(@PathVariable("orderId") long orderId) {
        Order found = orderService.findOrderById(orderId);
        if (found != null){
            return found;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    OrderService orderService;


}
