package org.javacream.store.rest;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreRestService {

	@Autowired private StoreService storeService;
	
	@RequestMapping(method=RequestMethod.POST, path="/store/{category}/{item}")
	public int getStock(@PathVariable("category") String category, @PathVariable("item")String item){
		return storeService.getStock(category, item);
	}
}
