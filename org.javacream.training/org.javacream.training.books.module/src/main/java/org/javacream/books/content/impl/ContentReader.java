package org.javacream.books.content.impl;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ContentReader {

	@Value("${contentServiceEndpointUrl}")
	private String contentServiceEndpointUrl;
	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;
	@Autowired
	private RestTemplate restTemplate;

	public String readFromContentService(String id) {
		Supplier<String> supplier = () -> restTemplate.getForObject(contentServiceEndpointUrl + id + "?delay=100", String.class);
		return circuitBreakerFactory.create("contentCircuitBreaker").run(supplier);
	}
}
