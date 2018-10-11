package org.javacream.store.web.rest;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestStoreService {

	@Autowired private StoreService storeService;
	@RequestMapping(method=RequestMethod.GET, path="/store/{category}/{item}")
	public int getStock(@PathVariable(name="category") String category, @PathVariable(name="item") String item) {
		return storeService.getStock(category, item);
	}
}
