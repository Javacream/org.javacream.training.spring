package org.javacream.training.books.order.web;

import org.javacream.books.order.impl.SimpleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderWebService {

	@Autowired
	private SimpleOrderService orderService;

	@PostMapping(path = "order/{isbn}/{amount}")
	public String order(@PathVariable("isbn") String isbn, @PathVariable("amount") int amount) {
		try {
			return "OrderStatus: " + orderService.order(isbn, amount);
		} catch (RuntimeException re) {
			return "OrderStatus: false (isbn not found)";

		}
	}

}
