package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreWebService {

    @GetMapping(path="api/store/{category}")
    public String getStock(@PathVariable("category") String category, @RequestHeader("item") String item) {
        return "Stock: " + storeService.getStock(category, item);
    }

    @PostMapping(path="api/store")
    public void setStock(@RequestHeader("category") String category, @RequestHeader("item")String item, @RequestHeader("stock") int stock) {
        storeService.setStock(category, item, stock);
    }

    @Autowired private StoreService storeService;

}
