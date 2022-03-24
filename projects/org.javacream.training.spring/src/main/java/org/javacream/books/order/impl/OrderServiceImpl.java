package org.javacream.books.order.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.SequenceIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private BooksService booksService;
	@Autowired
	private StoreService storeService;
	@Autowired
	SequenceIdGenerator idGenerator;
	@Autowired
	
	@PersistenceContext private EntityManager entityManager;

	@Override
	public Order order(String isbn, int number) {
		OrderStatus orderStatus;
		double totalPrice = 0;
		try {
			Book book = booksService.findBookByIsbn((isbn));
			totalPrice = number * book.getPrice();
			if (storeService.getStock("books", isbn) >= number) {
				orderStatus = OrderStatus.OK;
			} else {
				orderStatus = OrderStatus.PENDING;
			}
		} catch (BookException e) {
			orderStatus = OrderStatus.UNKNOWN;
		}
		Order newOrder = new Order(idGenerator.next(), isbn, number, totalPrice, orderStatus);
		entityManager.persist(newOrder);
		return newOrder;
	}

	@Override
	public List<Order> allOrders() {
		return entityManager.createQuery("select o from OrderEntity as o", Order.class).getResultList();
	}

}
