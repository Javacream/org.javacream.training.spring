package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsbnGeneratorWebService {

    @PostMapping(path = "api/isbn", produces = MediaType.TEXT_PLAIN_VALUE)
    public String next() {
        return isbnGeneratorService.next();
    }

    @Autowired @IsbnGeneratorService.SequenceStrategy private IsbnGeneratorService isbnGeneratorService;


}
