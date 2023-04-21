package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService {

    @GetMapping(path="api/store/{category}")
    public String getStock(@PathVariable("category") String category, @RequestHeader("item") String item) {
        return "Stock: " + storeService.getStock(category, item);
    }

    @Autowired private StoreService storeService;

}
