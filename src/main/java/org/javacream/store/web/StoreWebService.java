package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StoreWebService {
	@Autowired private StoreService storeService;
	@Autowired  @Qualifier("store") private RestTemplate restTemplate;

	//1) store?cat=books&item=ISBN1
	//2) store/books/ISBN1
	//1)@GetMapping(path = "store", produces = "text/plain")
	// 1)public String getStock(@RequestParam("cat") String category, @RequestParam("item") String item) {
	@GetMapping(path = "store/{cat}/{item}", produces = "text/plain")
		public String getStock(@PathVariable("cat") String category, @PathVariable("item") String item) {
		return "Generated Stock: " + storeService.getStock(category, item) + " owned by " + getOwner();
	}
	
	public String getOwner() {
		String owner = restTemplate.getForObject("http://h2908727.stratoserver.net:8080/people/6", String.class);
		return owner;
	}
}
