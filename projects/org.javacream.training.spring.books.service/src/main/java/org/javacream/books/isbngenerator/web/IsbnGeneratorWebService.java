package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsbnGeneratorWebService {
	@Autowired
	@IsbnGeneratorService.SequenceStrategy
	IsbnGeneratorService sequenceIsbnGenerator;
	@Autowired
	@IsbnGeneratorService.RandomStrategy
	IsbnGeneratorService randomIsbnGenerator;

	@PostMapping(path = "api/isbn")
	public String nextIsbn(@RequestParam(name = "strategy", defaultValue = "s") String strategy) {
		if ("r".equals(strategy)) {
			return randomIsbnGenerator.next();
		} else {
			return sequenceIsbnGenerator.next();
		}
	}
}