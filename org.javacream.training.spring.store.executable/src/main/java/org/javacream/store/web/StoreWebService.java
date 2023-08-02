package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreWebService {//implements StoreService{ NIE DIE FACHLICHE SCHNITTSTELLE NUTZEN

    @GetMapping(path="api/store/{c}/{i}")
    public String getStock(@PathVariable("c") String category, @PathVariable("i") String item) {
//     @GetMapping(path="api/store")
//        public String getStock(@RequestHeader("cat") String category, @RequestParam("id") String item) {
        return "Stock: " + storeService.getStock(category, item);
    }

    @Autowired private StoreService storeService;
}
