package org.javacream.books.order.api;

import java.util.Objects;

public class Order {

	private long orderId;
	
	public Order() {}
	private String isbn;
	public long getOrderId() {
		return orderId;
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


	private int number;
	@Override
	public int hashCode() {
		return Objects.hash(number, isbn, orderId, status, totalPrice);
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
		return number == other.number && Objects.equals(isbn, other.isbn) && orderId == other.orderId
				&& status == other.status
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", isbn=" + isbn + ", amount=" + number + ", totalPrice=" + totalPrice
				+ ", status=" + status + "]";
	}


	public Order(long orderId, String isbn, int number, double totalPrice, OrderStatus status) {
		super();
		this.orderId = orderId;
		this.isbn = isbn;
		this.number = number;
		this.totalPrice = totalPrice;
		this.status = status;
	}


	private double totalPrice;
	private OrderStatus status;

	
	public enum OrderStatus{
		OK, PENDING, UNAVAILABLE
	}
}
