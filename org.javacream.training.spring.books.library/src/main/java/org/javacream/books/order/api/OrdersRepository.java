package org.javacream.books.order.api;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository  extends JpaRepository<Order, Long> {
}
