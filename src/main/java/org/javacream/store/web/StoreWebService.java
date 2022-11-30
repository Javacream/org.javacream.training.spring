package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService {

	@Autowired private StoreService storeService;

	@GetMapping(path="api/store", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getStock(@RequestHeader("cat") String category, @RequestHeader("item") String item) {
		return "Stock:" + storeService.getStock(category, item);
	}
	
}
