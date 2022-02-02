package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Transactional
public class EntityOrderService implements OrderService {

    @Autowired private BooksService booksService;
    @Autowired private StoreService storeService;
    @Autowired private IdGenerator idGenerator;

    @PersistenceContext private EntityManager entityManager;
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
        entityManager.persist(order);
        return order;
    }

    @Override
    public List<Order> allOrders() {
        return entityManager.createQuery("select o from OrderEntity as o", Order.class).getResultList();
    }

    @Override
    public Order findOrderById(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<Order> findOrdersByIsbn(String isbn) {
        TypedQuery<Order> query = entityManager.createQuery("select o from OrderEntity as o where o.isbn = : isbn", Order.class);
        query.setParameter("isbn", isbn);
        return query.getResultList();
    }

    @Override
    public List<Order> findOrdersByCustomer(String customer) {
        TypedQuery<Order> query = entityManager.createQuery("select o from OrderEntity as o where o.customer = : customer", Order.class);
        query.setParameter("customer", customer);
        return query.getResultList();
    }
}
