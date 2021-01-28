package org.javacream.books.order.web;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderWebService {
    @Autowired private OrderService orderService;

    //curl -X POST -verbose -d '{"isbn": "ISBN42", "number": 5}' -H "Accept: application/json" -H "Content-Type: application/json" http://localhost:9090/api/order
    @PostMapping(path = "api/order", produces = "application/json", consumes = "application/json") public Order createOrderAsJsonWithPostAndBody(@RequestBody  CreateOrderParams params){
        Order order = orderService.order(params.getIsbn(), params.getNumber());
        return order;
    }
}
