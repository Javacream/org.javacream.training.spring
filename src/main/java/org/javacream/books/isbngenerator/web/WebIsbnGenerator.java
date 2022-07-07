package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class WebIsbnGenerator {
    @Autowired @IsbnGenerator.SequenceStrategy private IsbnGenerator sequenceIsbnGenerator;
    @Autowired @IsbnGenerator.RandomStrategy private IsbnGenerator randomIsbnGenerator;

    @PostMapping(path =  "api/isbns", produces = MediaType.TEXT_PLAIN_VALUE) public String nextIsbn(@RequestHeader("strategy") WebStrategy strategy){
        switch(strategy){
            case RND:
                return randomIsbnGenerator.next();
            case SEQ:
                return sequenceIsbnGenerator.next();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
