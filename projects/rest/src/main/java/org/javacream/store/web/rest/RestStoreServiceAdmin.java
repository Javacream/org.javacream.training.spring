package org.javacream.store.web.rest;

import org.javacream.store.api.StoreServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestStoreServiceAdmin {

	@Autowired
	private StoreServiceAdmin storeService;

	@RequestMapping(method = RequestMethod.GET, path = "/admin/store/{category}/{item}")
	public int getStock(@PathVariable(name = "category") String category, @PathVariable(name = "item") String item) {
		return storeService.getStock(category, item);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/admin/store/{category}/{item}/{stock}")
	public void setStock(@PathVariable(name = "category") String category, @PathVariable(name = "item") String item,
			@PathVariable("stock") Integer stock) {
		storeService.setStock(category, item, stock);
	}

}
