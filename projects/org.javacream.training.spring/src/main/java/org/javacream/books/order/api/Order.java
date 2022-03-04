package org.javacream.books.order.api;

import java.util.Objects;

public class Order {
	private Long orderId;
	public Order(Long orderId, String isbn, int number, double totalPrice, OrderStatus status) {
		super();
		this.orderId = orderId;
		this.isbn = isbn;
		this.number = number;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", isbn=" + isbn + ", number=" + number + ", totalPrice=" + totalPrice
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn, number, orderId, status, totalPrice);
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
		return Objects.equals(isbn, other.isbn) && number == other.number && Objects.equals(orderId, other.orderId)
				&& status == other.status
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}

	public Long getOrderId() {
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

	private String isbn;
	private int number;
	private double totalPrice;
	private OrderStatus status;

	public enum OrderStatus{
		OK, PENDING, UNKNOWN;
	}
}
