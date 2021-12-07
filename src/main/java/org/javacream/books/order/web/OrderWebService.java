package org.javacream.books.order.web;

import java.util.List;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.repository.OrderRepository;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class OrderWebService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private BooksRepository booksRepository;

	@PostMapping(path = "api/order/{isbn}/{number}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String newOrder(@PathVariable("isbn") String isbn, @PathVariable("number") int number) {
		try {
			Order order = new Order();
			order.setBook(booksRepository.findById(isbn).get());
			order.setNumber(number);
			orderRepository.save(order);
			return "ID: " + order.getOrderId();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
		}
	}

	@GetMapping(path = "api/order", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Order> showAll() {
		return orderRepository.findAll();
	}

	@GetMapping(path = "api/order/demo", produces = MediaType.TEXT_PLAIN_VALUE)
	public String doDemo() {
		Book bookByOrder = orderRepository.findById(1l).get().getBook();
		Book bookByBook = booksRepository.findById("ISBN1").get();
		return "Identity: " + (bookByOrder == bookByBook); 
	}

}
