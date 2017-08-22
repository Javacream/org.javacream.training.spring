package org.javacream.books.isbngenerator.rest;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsbnGeneratorRestService {
	@Autowired
	private IsbnGenerator isbnGenerator;

	@RequestMapping(method=RequestMethod.POST, path="/isbn")
	public String next() {
		return isbnGenerator.next();
	}
}
