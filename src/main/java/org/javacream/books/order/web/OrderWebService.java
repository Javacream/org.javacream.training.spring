package org.javacream.books.order.web;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class OrderWebService{
    @Autowired private OrderService orderService;


    @PostMapping(path = "api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order order(@RequestParam("isbn") String isbn, @RequestParam("number") int amount) {
        return orderService.order(isbn, amount);
    }

    @GetMapping(path="api/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order findOrderById(@PathVariable("id") long id) {

        try {
            return orderService.findOrderById(id);
        }
        catch(RuntimeException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND );
        }
    }



}
