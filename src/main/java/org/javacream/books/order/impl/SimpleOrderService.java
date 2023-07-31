package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SimpleOrderService implements OrderService {

    @Autowired private BooksService booksService;
    @Autowired private StoreService storeService;
    private Long orderId = 0l;
    @Autowired Map<Long, Order> ordersMap;
    @Override
    public Order order(String isbn, int number) {
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
        Order order = new Order(orderId++, isbn, number, totalPrice, orderStatus);
        ordersMap.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public Order findOrderById(long orderId) {
        return ordersMap.get(orderId);
    }

}