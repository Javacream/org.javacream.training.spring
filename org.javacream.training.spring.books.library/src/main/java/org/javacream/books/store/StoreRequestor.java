package org.javacream.books.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StoreRequestor {
    @Value("${store.endpoint}") private String endpoint;
    public int getStock(String category, String item){
        String url = String.format("%s/%s/%s", endpoint,category,item);
        WebClient client = WebClient.create(url);
        String result = client.get().retrieve().bodyToMono(String.class).block().toString();//Blocking
        return Integer.parseInt(result.substring(7));//it was stupid to return the String Stock: 42....
    }
}
