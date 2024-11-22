package org.javacream.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleKafkaListener {

    @KafkaListener(topics = "javacream", groupId = "javacream")
    public void listen(String message){
        System.out.println("##### " + message);
    }
}
