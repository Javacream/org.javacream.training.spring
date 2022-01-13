package org.javacream.books.warehouse.api;

public class SpecialistBook extends Book {
    private String subject;

    public String getSubject() {
        return subject;
    }

    public SpecialistBook(String isbn, String title, Integer pages, Double price, Boolean available, String subject) {
        super(isbn, title, pages, price, available);
        this.subject = subject;
    }
}
