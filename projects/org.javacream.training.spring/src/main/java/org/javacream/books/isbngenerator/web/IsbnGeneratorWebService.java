package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class IsbnGeneratorWebService {
	@Autowired
	@SequenceStrategy
	private IsbnGenerator sequenceIsbnGenerator;
	@Autowired
	@RandomStrategy
	private IsbnGenerator randomIsbnGenerator;

	@PostMapping(path = "api/isbn", produces = MediaType.TEXT_PLAIN_VALUE)
	public String next(@RequestHeader(name = "strategy", required = false, defaultValue = "random") String strategy) {
		if ("random".equals(strategy)) {
			return randomIsbnGenerator.next();
		} else if ("sequence".equals(strategy)) {
			return sequenceIsbnGenerator.next();
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

}
