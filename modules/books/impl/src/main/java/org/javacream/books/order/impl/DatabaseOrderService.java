package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderRepository;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.store.ReadingStoreService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED)

public class DatabaseOrderService implements OrderService {
    @Autowired private KafkaTemplate kafkaTemplate;
    @Autowired
    OrderRepository orderRepository;
    @Autowired private BooksService booksService;
    @Autowired private ReadingStoreService storeService;
    private Long orderId = 0l;
    @Override
    public Long order(String isbn, Integer number) {
        Order.OrderStatus orderStatus;
        Double totalPrice = null;

        try{
            Book book = booksService.findBookByIsbn(isbn);
            totalPrice = number * book.getPrice();
            if (storeService.getStock(isbn) >= number){
                orderStatus = Order.OrderStatus.OK;
            }else{
                orderStatus = Order.OrderStatus.PENDING;
            }
        }
        catch(BookException e){
            orderStatus = Order.OrderStatus.UNAVAILABLE;
        }
        Order order = new Order(orderId++, isbn, number, totalPrice, orderStatus);
        orderRepository.save(order);
        kafkaTemplate.send("orders", "Created Order " + order.getOrderId());
        return order.getOrderId();
    }

    @Override
    public Order findById(Long orderId) {
        return orderRepository.findById(orderId).orElseGet(() -> null);
    }

}