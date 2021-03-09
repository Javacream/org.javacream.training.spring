package org.javacream.books.order.impl;

import java.util.Optional;

import org.javacream.books.order.api.OrderEntity;
import org.javacream.books.order.api.OrderRepository;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.api.OrderStatus;
import org.javacream.books.repository.api.BookEntity;
import org.javacream.books.repository.api.BooksRepository;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DatabaseOrderService implements OrderService {
	@Autowired
	@Qualifier("plain")
	private StoreService storeService;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private BooksRepository booksRepository;

	@Override
	public OrderEntity order(String isbn, int number) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setIsbn(isbn);
		try {
			Optional<BookEntity> bookResult = booksRepository.findById(isbn);
			BookEntity bookEntity = bookResult.get();
			orderEntity.setTotalPrice(number * bookEntity.getPrice());
			if (storeService.getStock("books", isbn) >= number) {
				orderEntity.setStatus(OrderStatus.OK);
			} else {
				orderEntity.setStatus(OrderStatus.PENDING);
			}
		} catch (RuntimeException be) {
			orderEntity.setStatus(OrderStatus.UNAVAILABLE);
		}
		orderRepository.save(orderEntity);
		return orderEntity;
	}

}
