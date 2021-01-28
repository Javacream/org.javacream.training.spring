package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebService {
    @Autowired private StoreService storeService;

    @GetMapping(path="api/store/{category}/{item}", produces = MediaType.TEXT_PLAIN_VALUE) public String getStock(@PathVariable("category") String category, @PathVariable("item") String item){
        return Integer.toString(storeService.getStock(category, item));
    }


    @GetMapping(path="api/store/ISBN{id}", produces = MediaType.TEXT_PLAIN_VALUE) public String getStock(@PathVariable("id") String id){
        return Integer.toString(storeService.getStock("books", "ISBN" + id));
    }

}
