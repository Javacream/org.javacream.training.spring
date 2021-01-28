package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsbnGeneratorWebService {

@Autowired @IsbnGeneratorService.RandomStrategy private IsbnGeneratorService randomIsbnGenerator;
@Autowired @IsbnGeneratorService.SequenceStrategy private IsbnGeneratorService sequenceIsbnGenerator;

//curl -H "strategy: random" -X POST http://localhost:9090/api/isbn

@PostMapping(path = "api/isbn") public String isbn(@RequestHeader("strategy") String strategy){
    if("sequence".equals(strategy)){
        return sequenceIsbnGenerator.next();
    }else{
        return randomIsbnGenerator.next();
    }
}

}
