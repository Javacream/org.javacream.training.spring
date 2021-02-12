package org.javacream.books.order.api;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="ORDERS")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlAttribute
	@Id
	private long orderId;
    private String isbn;

    private int number;
    @Column(name = "sum")
    private double totalPrice;
    private OrderStatus status;

    public Order(){}
    public Order(long orderId, String isbn, int number, double totalPrice, OrderStatus status) {
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
        return orderId == order.orderId &&
                number == order.number &&
                Double.compare(order.totalPrice, totalPrice) == 0 &&
                Objects.equals(isbn, order.isbn) &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, isbn, number, totalPrice, status);
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
