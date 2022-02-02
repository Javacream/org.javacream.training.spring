package org.javacream.books.order.api;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity(name="OrderEntity")
public class Order {
    @Id
    private Long orderId;

    private Order(){}
    private String isbn;
    private Integer number;
    private Double totalPrice;
    private String customer;
    private OrderStatus status;


    public Order(Long orderId, String isbn, Integer number, Double totalPrice, String customer, OrderStatus status) {
        this.orderId = orderId;
        this.isbn = isbn;
        this.number = number;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", isbn='" + isbn + '\'' +
                ", number=" + number +
                ", totalPrice=" + totalPrice +
                ", customer='" + customer + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(isbn, order.isbn) && Objects.equals(number, order.number) && Objects.equals(totalPrice, order.totalPrice) && Objects.equals(customer, order.customer) && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, isbn, number, totalPrice, customer, status);
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getNumber() {
        return number;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String getCustomer() {
        return customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public static enum OrderStatus{
        OK, UNAVAILABLE, PENDING;
    }
}
