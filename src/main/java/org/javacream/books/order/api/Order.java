package org.javacream.books.order.api;

import java.util.Objects;

public class Order {

	private long orderId;
	private String isbn;
	public long getOrderId() {
		return orderId;
	}


	public String getIsbn() {
		return isbn;
	}


	public int getAmount() {
		return amount;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public OrderStatus getStatus() {
		return status;
	}


	private int amount;
	@Override
	public int hashCode() {
		return Objects.hash(amount, isbn, orderId, status, totalPrice);
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
		return amount == other.amount && Objects.equals(isbn, other.isbn) && orderId == other.orderId
				&& status == other.status
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", isbn=" + isbn + ", amount=" + amount + ", totalPrice=" + totalPrice
				+ ", status=" + status + "]";
	}


	public Order(long orderId, String isbn, int amount, double totalPrice, OrderStatus status) {
		super();
		this.orderId = orderId;
		this.isbn = isbn;
		this.amount = amount;
		this.totalPrice = totalPrice;
		this.status = status;
	}


	private double totalPrice;
	private OrderStatus status;

	
	public enum OrderStatus{
		OK, PENDING, UNAVAILABLE;
	}
}
