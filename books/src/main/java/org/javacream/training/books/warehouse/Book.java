package org.javacream.training.books.warehouse;

import java.util.Objects;

public class Book {
    private String isbn;
    private String title;
    private Integer pages;
    private Double price;
    private Boolean available;

    public Book(String isbn, String title, Integer pages, Double price, Boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.pages = pages;
        this.price = price;
        this.available = available;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPages() {
        return pages;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

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
}
