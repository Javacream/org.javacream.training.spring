package org.javacream.books.warehouse.web;

import java.util.Objects;

public class BookInfo {

    public BookInfo(){}

    @Override
    public String toString() {
        return "BookInfo{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookInfo bookInfo = (BookInfo) o;
        return Objects.equals(isbn, bookInfo.isbn) && Objects.equals(title, bookInfo.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title);
    }

    public BookInfo(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String isbn;
    private String title;
}
