package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService {

    @Autowired @Qualifier("books") private StoreService storeService;

    @GetMapping(path = "api/store/{cat}/{item}")
    public String getStock(@PathVariable("cat") String category, @PathVariable
            ("item") String item) {
        return "Stock: " + storeService.getStock(category, item);
    }
}
