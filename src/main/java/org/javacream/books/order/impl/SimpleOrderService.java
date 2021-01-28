package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.api.OrderStatus;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SimpleOrderService implements OrderService {
    @Autowired private IdGenerator idGenerator;
    @Autowired @Qualifier("forOrderActor") private BooksService booksService;
    @Autowired private StoreService storeService;
    @Override
    public Order order(String isbn, int number) {
        try{
            Book book = booksService.findBookByIsbn(isbn);
            double totalPrice = book.getPrice() * number;
            int stock = storeService.getStock("books", isbn);
            OrderStatus status;
            if (stock < number){
                status = OrderStatus.PENDING;
            }else{
                status = OrderStatus.OK;
            }
            return new Order(idGenerator.id(), isbn, number, totalPrice, status);
        }catch(BookException be){
            return new Order(idGenerator.id(), isbn, number, 0, OrderStatus.UNAVAILABLE);
        }
    }
}
