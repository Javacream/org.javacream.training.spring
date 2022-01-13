package org.javacream.books.warehouse.api;

public class SchoolBook extends Book {
    private Integer year;
    private String topic;

    public Integer getYear() {
        return year;
    }

    public String getTopic() {
        return topic;
    }

    public SchoolBook(String isbn, String title, Integer pages, Double price, Boolean available, Integer year, String topic) {
        super(isbn, title, pages, price, available);
        this.year = year;
        this.topic = topic;
    }
}
