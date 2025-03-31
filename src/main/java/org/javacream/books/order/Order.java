package org.javacream.books.order;

public record Order(Long orderId, String isbn, int amount, Double totalPrice, OrderStatus status) {

    public enum OrderStatus{
        OK, PENDING, UNAVAILABLE
    }
}
