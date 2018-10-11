package org.javacream.store.impl;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("storeService")
public class StoreRestServiceStub implements StoreService {
	@Autowired private RestTemplate restTemplate;
	@Override
	public int getStock(String category, String item) {
		ResponseEntity<Integer> result = restTemplate.getForEntity("http://localhost:8080/store/" + category + "/" + item, Integer.class);
		return result.getBody();
	}


}