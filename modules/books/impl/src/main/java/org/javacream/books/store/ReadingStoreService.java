package org.javacream.books.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReadingStoreService {

    @Autowired
    private RestTemplate restTemplate;
    public int getStock(String isbn) {
        return Integer.parseInt(restTemplate.getForObject("http://localhost:9090/api/store/books/" + isbn, String.class));

    }
}
