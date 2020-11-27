package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService {

	@Autowired
	@Qualifier("forBooksService")
	private StoreService storeService;

	// localhost:8080/api/store/books/ISBN1
	@GetMapping(path = "api/store/{category}/{item}")
	@Secured("ROLE_USER")
	public int getStockPath(@PathVariable("category") String category, @PathVariable("item") String item) {
		return storeService.getStock(category, item);
	}
	/*
	 * //localhost:8080/api/store?category=books&item=ISBN1
	 * 
	 * @GetMapping(path = "api/store") public int
	 * getStockWithRequestParams(@RequestParam("category")String
	 * category, @RequestParam("item") String item) { return
	 * storeService.getStock(category, item); } //localhost:8080/api/store
	 * 
	 * @GetMapping(path = "api/store") public int
	 * getStockWithHeaderParams(@RequestHeader("category")String
	 * category, @RequestHeader("item") String item) { return
	 * storeService.getStock(category, item); } //localhost:8080/api/store/ISBN1
	 * 
	 * @GetMapping(path = "api/store/{item}") public int
	 * getStock(@RequestHeader("category")String category, @PathVariable("item")
	 * String item) { return storeService.getStock(category, item); }
	 */
}
