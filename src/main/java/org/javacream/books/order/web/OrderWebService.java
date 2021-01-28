package org.javacream.books.order.web;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "api/order", produces = "application/json") public Order createOrderAsJsonWithPost(@RequestParam("isbn") String isbn, @RequestParam("number") int number){
        Order order = orderService.order(isbn, number);
        return order;

    }

    //curl -X POST -verbose -d "{'isbn': 'ISBN42', 'number': 5}" -H "Accept: application/json" -H "Content-Type: application/json" "http://localhost:9090/api/order
    @PostMapping(path = "api/order", produces = "application/json", consumes = "application/json") public Order createOrderAsJsonWithPostAndBody(@RequestBody  CreateOrderParams params){
        Order order = orderService.order(params.getIsbn(), params.getNumber());
        return order;

    }


}
