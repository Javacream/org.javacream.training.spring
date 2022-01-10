package org.javacream.training.books.warehouse;

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
