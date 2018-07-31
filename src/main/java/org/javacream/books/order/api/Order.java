package org.javacream.books.order.api;
public class Order{
	public Order() {
		
	}
	private Long orderId;
	public Long getOrderId() {
		return orderId;
	}
	public String getIsbn() {
		return isbn;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public OrderStatus getStatus() {
		return status;
	}
	private String isbn;
	private Double totalPrice;
	public Order(Long orderId, String isbn, Double totalPrice, OrderStatus status) {
		super();
		this.orderId = orderId;
		this.isbn = isbn;
		this.totalPrice = totalPrice;
		this.status = status;
	}
	private OrderStatus status;
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", isbn=" + isbn + ", totalPrice=" + totalPrice + ", status=" + status
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		return result;
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
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (status != other.status)
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}