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
}
