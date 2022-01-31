package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreWebService{

    @Autowired private StoreService storeService;

    @GetMapping(path = "api/store/{cat}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getStock(@PathVariable("cat") String category, @PathVariable("item") String itemId) {
        return "Stock: " + storeService.getStock(category, itemId);
    }
    @GetMapping(path = "api/store", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getStockWithHeader(@RequestHeader("cat") String category, @RequestHeader("item") String itemId) {
        return "Stock: " + storeService.getStock(category, itemId);
    }
    @GetMapping(path = "api/store/query", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getStockWithQuery(@RequestParam("cat") String category, @RequestParam("item") String itemId) {
        return "Stock: " + storeService.getStock(category, itemId);
    }

}
