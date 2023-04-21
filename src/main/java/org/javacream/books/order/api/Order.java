package org.javacream.books.order.api;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    private Long orderId;
    private String isbn;
    private Integer number;
    private Double totalPrice;
    private OrderStatus status;

    private Order(){}
    public Order(Long orderId, String isbn, Integer number, Double totalPrice, OrderStatus status) {
        this.orderId = orderId;
        this.isbn = isbn;
        this.number = number;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", isbn='" + isbn + '\'' +
                ", number=" + number +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(isbn, order.isbn) && Objects.equals(number, order.number) && Objects.equals(totalPrice, order.totalPrice) && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, isbn, number, totalPrice, status);
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

    public OrderStatus getStatus() {
        return status;
    }

    public static enum OrderStatus{
        OK, UNAVAILABLE, PENDING;
    }
}