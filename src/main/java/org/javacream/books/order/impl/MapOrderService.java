package org.javacream.books.order.impl;

import org.javacream.books.order.Order;
import org.javacream.books.order.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MapOrderService implements OrderService {
    @Autowired private BooksService booksService;
    @Autowired @Qualifier("order") private StoreService storeService;
    @Autowired private IdGenerator idGenerator;
    private Map<Long, Order> orders;

    {
        orders = new HashMap<>();
    }

    @Override
    public long order(String isbn, int amount) {
        long id = idGenerator.next();
        try{
            Book book = booksService.findBookByIsbn(isbn);
            double totalPrice = book.getPrice()*amount;
            int stock = storeService.getStock("books", isbn);
            Order.OrderStatus status;
            if (stock >= amount){
                status = Order.OrderStatus.OK;
            }else{
                status = Order.OrderStatus.PENDING;
            }
            orders.put(id, new Order(id, isbn, amount, totalPrice, status));
        }
        catch(BookException e){
            orders.put(id, new Order(id, isbn, amount, null, Order.OrderStatus.UNAVAILABLE));
        }
        return id;
    }

    @Override
    public Order findById(Long id) {
        return orders.get(id);
    }
}
