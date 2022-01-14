package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SimpleOrderService implements OrderService {

    @Autowired @Qualifier("orders") private Map<Long, Order> orders;
    @Autowired private BooksService booksService;
    @Autowired private StoreService storeService;
    @Autowired private IdGenerator idGenerator;
    @Override
    public Order order(String isbn, Integer number, String customer) {
        Order.OrderStatus orderStatus;
        Double totalPrice = null;

        try{
            Book book = booksService.findBookByIsbn(isbn);
            totalPrice = number * book.getPrice();
            if (storeService.getStock("books", isbn) >= number){
                orderStatus = Order.OrderStatus.OK;
            }else{
                orderStatus = Order.OrderStatus.PENDING;
            }
        }
        catch(BookException e){
            orderStatus = Order.OrderStatus.UNAVAILABLE;
        }
        Order order = new Order(idGenerator.nextId(), isbn, number, totalPrice, customer, orderStatus);
        orders.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public List<Order> allOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public Order findOrderById(Long id) {
        return orders.get(id);
    }

    @Override
    public List<Order> findOrdersByIsbn(String isbn) {
        return orders.values().stream().filter(order -> order.getIsbn().equals(isbn)).collect(Collectors.toList());
    }

    @Override
    public List<Order> findOrdersByCustomer(String customer) {
        return orders.values().stream().filter(order -> order.getCustomer().equals(customer)).collect(Collectors.toList());
    }
}
