package org.javacream.books.isbngenerator.web;

import javax.annotation.PostConstruct;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("request")
public class WebIsbnGenerator {

	@Autowired @SequenceStrategy private IsbnGenerator sequenceIsbnGenerator;
	@Autowired @RandomStrategy private IsbnGenerator randomIsbnGenerator;

	@PostMapping(path = "api/isbn", produces = MediaType.TEXT_PLAIN_VALUE)
	public String next(@RequestParam(name = "strategy", required = false) String strategy) {
		if ("sequence".equals(strategy)) {
			return sequenceIsbnGenerator.next() + " " + this;
		}else if ("random".equals(strategy)) {
			return randomIsbnGenerator.next();
		}else {
			return "unknown strategy: " + strategy;
		}
		
	}
	
	@PostConstruct public void init() {
		System.out.println("initializing " + this);
	}
}
