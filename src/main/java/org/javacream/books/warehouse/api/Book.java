package org.javacream.books.warehouse.api;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Book implements Serializable {
	@Id
	private String isbn;
	private String title;
	private int pages;
	private double price;
	@Transient
	private boolean available;

	@Override
	public String toString() {
		return "Book{" +
				"isbn='" + isbn + '\'' +
				", title='" + title + '\'' +
				", pages=" + pages +
				", price=" + price +
				", available=" + available +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return pages == book.pages && Double.compare(price, book.price) == 0 && available == book.available && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn, title, pages, price, available);
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public int getPages() {
		return pages;
	}

	public double getPrice() {
		return price;
	}

	public boolean isAvailable() {
		return available;
	}

	public Book(String isbn, String title, double price, int pages, boolean available){
		this.isbn = isbn;
		this.title = title;
		this.pages = pages;
		this.price = price;
		this.available = available;
	}
	public Book(String isbn, String title){
		this(isbn, title, 0, 0, false);
	}
}
