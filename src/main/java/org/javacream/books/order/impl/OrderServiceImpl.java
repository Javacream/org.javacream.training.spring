package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderRepository;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ObjectStreamConstants;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService, ObjectStreamConstants {
    @Autowired
    private StoreService storeService;
    @Autowired
    private BooksService booksService;
    @Autowired
    private SequenceGenerator sequenceGenerator;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order order(String isbn, int amount) {

        OrderStatus status;
        long id = sequenceGenerator.nextSequence();
        double totalPrice = 0;
        try {
            Book book = booksService.findBookByIsbn(isbn);
            if (storeService.getStock("books", isbn) >= amount) {
                status = OrderStatus.OK;
                totalPrice = amount * book.getPrice();
            } else {
                status = OrderStatus.PENDING;
            }
        } catch (BookException e) {
            status = OrderStatus.UNAVAILABLE;
        }
        Order order = new Order(id, isbn, amount, totalPrice, status);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order findOrderById(long id) {
        Optional<Order> result = orderRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }else{
            throw new RuntimeException("no order forund for id" + id);
        }
    }

}