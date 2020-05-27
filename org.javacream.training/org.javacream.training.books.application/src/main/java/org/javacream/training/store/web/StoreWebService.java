package org.javacream.training.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService {

	@Autowired private StoreService storeService;

	@GetMapping(path = "store/{category}/{item}")
	public String getStock(@PathVariable("category") String category, @PathVariable("item")String item) {
		return Integer.toString(storeService.getStock(category, item));
	}
}
