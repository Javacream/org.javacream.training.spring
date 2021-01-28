package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class IsbnGeneratorWebService {

@Autowired @IsbnGeneratorService.RandomStrategy private IsbnGeneratorService randomIsbnGenerator;
@Autowired @IsbnGeneratorService.SequenceStrategy private IsbnGeneratorService sequenceIsbnGenerator;

//curl -H "strategy: random" -H "fetchSize: 10" -X POST http://localhost:9090/api/isbn

@PostMapping(path = "api/isbn", produces = "application/json") public List<String> isbn(@RequestHeader("strategy") String strategy, @RequestHeader("fetchSize") int fetchSize){
    if("sequence".equals(strategy)){
        return assemble(sequenceIsbnGenerator, fetchSize);
    }else{
        return assemble(randomIsbnGenerator, fetchSize);
    }
}

private List<String> assemble(IsbnGeneratorService isbnGenerator, int fetchSize){
    ArrayList<String> result = new ArrayList<>(fetchSize);
    for (int i = 0; i < fetchSize; i++){
        result.add(isbnGenerator.next());
    }
    return result;
}


}
