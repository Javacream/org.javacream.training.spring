package org.javacream.books.order.web;

import org.javacream.books.order.api.OrderEntity;
import org.javacream.books.order.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderWebService {

	@Autowired private OrderService orderService;

	@PostMapping(path="api/order", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderEntity order(@RequestParam("isbn") String isbn, @RequestParam("number") int number) {
		return orderService.order(isbn, number);
	}
}
