package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreRestService {

	@Autowired private StoreService storeService;

	@GetMapping(path = "store/{cat}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getStock(@PathVariable("cat") String category, @PathVariable("item")String item) {
		return "Stock: " + storeService.getStock(category, item);
	}
	
	
}
