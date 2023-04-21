package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestIsbnGenerator {

    @PostMapping(path="api/isbn", produces = MediaType.TEXT_PLAIN_VALUE)
    public String next(@RequestHeader("strategy") Strategy strategy) {
        if (strategy == Strategy.RANDOM){
            return randomIsbnGenerator.next();
        }else{
            return sequenceIsbnGenerator.next();
        }
    }

    @Autowired @IsbnGenerator.RandomStrategy
    private IsbnGenerator randomIsbnGenerator;

    @Autowired @IsbnGenerator.SequenceStrategy
    private IsbnGenerator sequenceIsbnGenerator;

    enum Strategy{
        RANDOM, SEQUENCE;
    }
}
