package org.javacream.training.books.warehouse.api;

public class BookException extends Exception {
    private BookExceptionType type;

    public BookExceptionType getType() {
        return type;
    }

    public BookException(BookExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public enum BookExceptionType{
            NOT_CREATED,
            NOT_FOUND,
            NOT_UPDATED,
            NOT_DELETED,
            TECHNICAL;
        }
}
