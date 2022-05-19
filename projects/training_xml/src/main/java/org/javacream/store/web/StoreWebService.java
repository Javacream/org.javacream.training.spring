package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService{ // implements StoreService{ -> FALSCH, das REST-API muss im Vergleich zum Fach-Interface frei modelliert werden können

	@Autowired @Audit private StoreService storeService;

	@GetMapping(path = "api/store/{cat}/{item}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String getStock(@PathVariable("cat") String category, @PathVariable("item") String item) {
		return "Stock" + storeService.getStock(category, item);
	}

	@GetMapping(path = "api/store/header", produces=MediaType.TEXT_PLAIN_VALUE)
	public String getStockWithHeaders(@RequestHeader("cat") String category, @RequestHeader("item") String item) {
		return "Stock" + storeService.getStock(category, item);
	}
	@GetMapping(path = "api/store/query", produces=MediaType.TEXT_PLAIN_VALUE)
	public String getStockWithQuery(@RequestParam("cat") String category, @RequestParam("item") String item) {
		return "Stock" + storeService.getStock(category, item);
	}
	@GetMapping(path = "api/store", produces=MediaType.TEXT_PLAIN_VALUE)
	public String getStockCombi(@RequestParam("cat") String category, @RequestHeader("item") String item) {
		return "Stock" + storeService.getStock(category, item);
	}

}
