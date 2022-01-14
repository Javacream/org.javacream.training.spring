package org.javacream.books.order.impl;

import org.springframework.stereotype.Service;

@Service
public class OrderIdGenerator {
    private Long counter = 0l;
    public Long nextOrderId(){
        return ++counter;
    }
}
