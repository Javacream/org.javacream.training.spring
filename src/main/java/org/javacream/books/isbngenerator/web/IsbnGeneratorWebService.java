package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsbnGeneratorWebService {

	@Autowired
	@RandomStrategy
	IsbnGenerator randomIsbnGenerator;
	@Autowired
	@SequenceStrategy
	IsbnGenerator sequenceIsbnGenerator;

	@PostMapping(path = "isbn", produces = MediaType.TEXT_PLAIN_VALUE)
	public String next(@RequestHeader("strategy") String strategy) {
		if ("random".equals(strategy)) {
			return randomIsbnGenerator.next();
		}else {
			return sequenceIsbnGenerator.next();
		}
	}

}
