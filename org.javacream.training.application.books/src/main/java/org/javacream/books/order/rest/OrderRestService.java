package org.javacream.books.order.rest;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestService {
	@Autowired OrderService orderService;

	@RequestMapping(method=RequestMethod.POST, path="/order/{isbn}")
	public Order order(@PathVariable("isbn")String isbn, @RequestParam("number") int number) {
		return orderService.createOrder(isbn, number);
	}
}
