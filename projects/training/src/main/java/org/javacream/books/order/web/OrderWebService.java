package org.javacream.books.order.web;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderWebService {

	@Autowired private OrderService orderService;

	@PostMapping(path = "api/orders/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Order order(@PathVariable("isbn") String isbn, @RequestParam("number") int number) {
		return orderService.order(isbn, number);
	}

	@GetMapping(path = "api/orders/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Order findOrderById(long id) {
		return orderService.findOrderById(id);
	}
	
}
