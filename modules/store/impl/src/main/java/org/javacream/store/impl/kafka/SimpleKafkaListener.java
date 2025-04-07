package org.javacream.store.impl.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleKafkaListener {
    @KafkaListener(topics = "orders")
    public void listen(String data){
        System.out.println("############## " + data);
    }
}
