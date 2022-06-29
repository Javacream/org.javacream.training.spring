package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService {

	@GetMapping(path = "api/store/{category}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getStock(String category, String item) {
		return "Stock: " + storeService.getStock(category, item);
	}
	@PostMapping(path = "api/store/{category}/{item}")
	public void setStock(String category, String item, @RequestHeader("stock") int stock) {
		storeService.setStock(category, item, stock);
	}

	@Autowired private StoreService storeService;
}