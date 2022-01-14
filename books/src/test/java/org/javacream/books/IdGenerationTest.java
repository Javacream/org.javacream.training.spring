package org.javacream.books;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class IdGenerationTest {
    @Autowired private BooksService booksService;
    @Autowired private OrderService orderService;
    @Test public void testIdGeneration(){
        String isbn = booksService.newBook("Spring", 19.99, 200);
        Order order = orderService.order("ISBN1", 3, "meier");
        System.out.println("Generated isbn=" + isbn +", generated orderId=" + order.getOrderId());

    }
}
