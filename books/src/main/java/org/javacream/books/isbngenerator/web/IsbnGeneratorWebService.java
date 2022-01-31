package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
import java.util.List;

@RestController
public class IsbnGeneratorWebService {

    @PostMapping(path = "api/isbn", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> next(@RequestHeader("strategy") String strategy, @RequestHeader(value = "fetchSize", defaultValue = "1") Integer fetchSize) {
        if ("random".equals(strategy)) {
            return createIsbns(randomIsbnGeneratorService, fetchSize);
        }else if ("sequence".equals(strategy)){
            return createIsbns(sequenceIsbnGeneratorService, fetchSize);

        }else{
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "unknown strategy: " + strategy);
        }
    }

    private List<String> createIsbns(IsbnGeneratorService isbnGeneratorService, Integer fetchSize){
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < fetchSize; i++){
            result.add(isbnGeneratorService.next());
        }
        return result;
    }
    @Autowired @IsbnGeneratorService.SequenceStrategy private IsbnGeneratorService sequenceIsbnGeneratorService;
    @Autowired @IsbnGeneratorService.RandomStrategy private IsbnGeneratorService randomIsbnGeneratorService;


}
