package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreWebService{

    @Autowired private StoreService storeService;

    @GetMapping(path = "api/store/{cat}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getStock(@PathVariable("cat") String category, @PathVariable("item") String itemId) {
        return "Stock: " + storeService.getStock(category, itemId);
    }

    @GetMapping(path = "api/store/{cat}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getItemsForCategory(@PathVariable("cat") String category) {
        return storeService.getItemIdsForCategory(category);
    }
    @PutMapping(path = "api/store/{cat}/{item}")
    public void setStock(@PathVariable("cat") String category, @PathVariable("item") String itemId, @RequestParam(name = "stock", defaultValue = "0") Integer stock) {
            storeService.setStock(category, itemId, stock);
    }

}
