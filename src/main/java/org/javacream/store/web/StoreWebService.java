package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService {

	@Autowired 
	private StoreService storeService;

	@GetMapping("api/store/{cat}/{item}")
	public int getStock(@PathVariable("cat")  String category, @PathVariable("item") String item) {
		return storeService.getStock(category, item);
	}
}
