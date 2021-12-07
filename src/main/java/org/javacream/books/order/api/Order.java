package org.javacream.books.order.api;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.javacream.books.warehouse.api.Book;

@Entity(name="OrderEntity")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@ManyToOne
	private Book book; 
	
	private int number;
	public Long getOrderId() {
		return orderId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public int hashCode() {
		return Objects.hash(book, number, orderId);
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
		return Objects.equals(book, other.book) && number == other.number && orderId == other.orderId;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", book=" + book + ", number=" + number + "]";
	}

}
