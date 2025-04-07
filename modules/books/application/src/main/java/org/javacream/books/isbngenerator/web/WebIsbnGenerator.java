package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebIsbnGenerator {

    @PostMapping(path = "api/isbngenerator")
    public String next() {
        return isbnGenerator.next();
    }

    @Autowired @IsbnGenerator.SequenceStrategy
    private IsbnGenerator isbnGenerator;

}
