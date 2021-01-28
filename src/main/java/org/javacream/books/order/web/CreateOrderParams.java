package org.javacream.books.order.web;

import java.util.Objects;

public class CreateOrderParams {
    private String isbn;
    private int number;

    @Override
    public String toString() {
        return "CreateOrderParams{" +
                "isbn='" + isbn + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrderParams that = (CreateOrderParams) o;
        return number == that.number &&
                Objects.equals(isbn, that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, number);
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
}
