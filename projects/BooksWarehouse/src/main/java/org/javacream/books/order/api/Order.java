package org.javacream.books.order.api;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String isbn;
	private int number;
	private double totalPrice;
	public Order() {
		super();
	}


	public Order(long id, String isbn, int number, double totalPrice, OrderStatus status) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.number = number;
		this.totalPrice = totalPrice;
		this.status = status;
	}


	public long getId() {
		return id;
	}


	public String getIsbn() {
		return isbn;
	}


	public int getNumber() {
		return number;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public OrderStatus getStatus() {
		return status;
	}


	private OrderStatus status;

	

	@Override
	public int hashCode() {
		return Objects.hash(isbn, number, status, totalPrice);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(isbn, other.isbn) && number == other.number && status == other.status
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}



	public static enum OrderStatus{
		OK, PENDING, UNAVAILABLE;
	}
	
	
}
