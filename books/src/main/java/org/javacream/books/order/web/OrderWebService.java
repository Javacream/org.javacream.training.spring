package org.javacream.books.order.web;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderWebService {
    @PostMapping(path = "api/order/{isbn}/{number}/{customer}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order order(@PathVariable("isbn")String isbn, @PathVariable("number") Integer number, @PathVariable("customer") String customer) {
        return orderService.order(isbn, number, customer);
    }

    @GetMapping(path = "api/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> allOrders() {
        return orderService.allOrders();
    }

    @GetMapping(path = "api/order/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order findOrderById(@PathVariable("id") Long id) {
        return orderService.findOrderById(id);
    }

    @GetMapping(path = "api/order/isbn/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> findOrdersByIsbn(@PathVariable("isbn")String isbn) {
        return orderService.findOrdersByIsbn(isbn);
    }

    @GetMapping(path = "api/order/customer/{customer}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> findOrdersByCustomer(@PathVariable("customer") String customer) {
        return orderService.findOrdersByCustomer(customer);
    }

    @Autowired private OrderService orderService;
}
