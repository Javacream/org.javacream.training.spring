package org.javacream.books;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class BooksTestConfiguration {

	@Bean @Qualifier("booksData") 
	public Map<String, Book> booksData() {
		HashMap<String, Book> data = new HashMap<>();
		Book b1 = new Book();
		b1.setIsbn("ISBN1");
		b1.setTitle("Title1");
		b1.setPrice(9.99);
		Book b2 = new Book();
		b2.setIsbn("ISBN2");
		b2.setTitle("Title2");
		b2.setPrice(19.99);
		data.put(b1.getIsbn(), b1);
		data.put(b1.getIsbn(), b2);
		return data;
	}
	@Bean @Qualifier("orderData") 
	public Map<Long, Order> orderData() {
		HashMap<Long, Order> data = new HashMap<>();
		Order orderOk = new Order(1l, "ISBN1", 100, 199.00, OrderStatus.OK);
		Order orderPending = new Order(2l, "ISBN2", 100, 199.00, OrderStatus.PENDING);
		Order orderUnavailable = new Order(3l, "ISBN3", 100, 199.00, OrderStatus.UNAVAILABLE);
		data.put(orderOk.getOrderId(), orderOk);
		data.put(orderPending.getOrderId(), orderPending);
		data.put(orderUnavailable.getOrderId(), orderUnavailable);
		return data;
		
	}

}
