package org.javacream.books.order.web;

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
    @Autowired OrderService orderService;
    @PostMapping(path = "api/order/{isbn}/{amount}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String create(@PathVariable("isbn") String isbn, @PathVariable("amount") int amount) {
        return "" + orderService.order(isbn, amount);
    }

    @GetMapping(path = "api/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order orderById(@PathVariable("id") long id){
        return orderService.findById(id);
    }
}
