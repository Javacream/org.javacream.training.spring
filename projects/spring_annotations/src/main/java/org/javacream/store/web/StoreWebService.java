package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService {

	@GetMapping(path = "api/store/{category}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getStock(String category, String item) {
		return "Stock: " + storeService.getStock(category, item);
	}

	@Autowired @Database private StoreService storeService;
}
