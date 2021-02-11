package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.api.OrderStatus;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Random();
@Service
public class SimpleOrderService implements OrderService {
    private Random random = new Random(System.currentTimeMillis())
    @Autowired private BooksService booksService;
    @Autowired private StoreService storeService;
    @Override
    public Order order(String isbn, int amount) {
        long orderId = random.nextLong();
        Order order;
        try{
            Book book = booksService.findBookByIsbn(isbn);
            double totalPrice = book.getPrice() * amount;
            int stock = storeService.getStock("books", isbn);
            OrderStatus status;
            if (stock < number){
                status = OrderStatus.PENDING;
            }else{
                status = OrderStatus.OK;
            }
            order =  new Order(orderId, isbn, amount, totalPrice, status);
        }catch(BookException be){
            order = new Order(orderId, isbn, amount, 0, OrderStatus.UNAVAILABLE);
        }
        return order;
    }
}
