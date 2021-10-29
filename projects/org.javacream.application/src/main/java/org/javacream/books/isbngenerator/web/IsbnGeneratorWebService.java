package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.SequenceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsbnGeneratorWebService {

	@Autowired
	@SequenceStrategy
	private IsbnGeneratorService sequenceIsbnGeneratorService;
	@Autowired
	@RandomStrategy
	private IsbnGeneratorService randomIsbnGeneratorService;

	@PostMapping(path = "api/isbn", produces = MediaType.TEXT_PLAIN_VALUE)
	public String next(@RequestHeader("strategy") String strategy) {
		if ("seq".equals(strategy)) {
			return sequenceIsbnGeneratorService.next();
		} else {
			return randomIsbnGeneratorService.next();
		}
	}

}
