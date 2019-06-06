package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebIsbnGenerator {
	@Autowired
	@Qualifier("sequence")
	IsbnGenerator sequenceIsbnGenerator;
	@Autowired
	@Qualifier("random")
	IsbnGenerator randomIsbnGenerator;

	@GetMapping(path = "isbn")
	public String nextIsbn(@RequestParam(name = "strategy", defaultValue="s") String strategy) {
		if ("r".equals(strategy)) {
			return randomIsbnGenerator.next();
		} else {
			return sequenceIsbnGenerator.next();
		}
	}
}
