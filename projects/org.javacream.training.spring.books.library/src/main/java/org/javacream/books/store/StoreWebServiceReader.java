package org.javacream.books.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StoreWebServiceReader {

	@Autowired
	@Qualifier("store")
	private RestTemplate restTemplate;

	public int getStock(String category, String id) {
		return Integer.parseInt(
				restTemplate.getForObject("http://localhost:8081/api/store/" + category + "/" + id, String.class));

	}
}