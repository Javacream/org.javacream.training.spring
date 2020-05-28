package org.javacream.books.content.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class SimpleEventConsumer {

	@StreamListener(Sink.INPUT) public void handleEvent(String message) {
		System.out.println("Handling message " + message);
	}
}

