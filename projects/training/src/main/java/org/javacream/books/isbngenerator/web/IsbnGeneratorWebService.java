package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsbnGeneratorWebService {

	@Autowired @IsbnGenerator.RandomStrategy private IsbnGenerator randomIsbnGenerator;
	@Autowired @IsbnGenerator.SequenceStrategy private IsbnGenerator sequenceIsbnGenerator;
	
	@PostMapping(path="api/isbn", produces = MediaType.TEXT_PLAIN_VALUE)
	public String next(@RequestHeader String strategy) {
		if ("rnd".equals(strategy)) {
			return randomIsbnGenerator.next();
		}else if("seq".equals(strategy)){
			return sequenceIsbnGenerator.next();
		}else {
			return "unknown strategy: " + strategy;
		}
	}
}
