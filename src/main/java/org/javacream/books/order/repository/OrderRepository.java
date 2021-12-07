package org.javacream.books.order.repository;

import org.javacream.books.order.api.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
