package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsbnGeneratorWebService {

    @PostMapping(path = "api/isbn", produces = MediaType.TEXT_PLAIN_VALUE)
    public String next(@RequestHeader("strategy") String strategy) {
        if ("random".equals(strategy)) {
            return randomIsbnGeneratorService.next();
        }else if ("sequence".equals(strategy)){
            return sequenceIsbnGeneratorService.next();

        }else{
            return "Unsupported strategy:" + strategy;
        }
    }

    @Autowired @IsbnGeneratorService.SequenceStrategy private IsbnGeneratorService sequenceIsbnGeneratorService;
    @Autowired @IsbnGeneratorService.RandomStrategy private IsbnGeneratorService randomIsbnGeneratorService;


}
