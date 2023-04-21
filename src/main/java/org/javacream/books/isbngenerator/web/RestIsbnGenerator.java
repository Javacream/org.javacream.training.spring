package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestIsbnGenerator {

    @PostMapping(path="api/isbn", produces = MediaType.TEXT_PLAIN_VALUE)
    public String next() {
        return isbnGenerator.next();
    }

    @Autowired @IsbnGenerator.RandomStrategy
    private IsbnGenerator isbnGenerator;


}
