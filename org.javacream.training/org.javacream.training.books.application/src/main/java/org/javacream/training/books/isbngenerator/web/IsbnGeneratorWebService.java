package org.javacream.training.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsbnGeneratorWebService {

	@Autowired @IsbnGenerator.SequenceStrategy private IsbnGenerator isbnGenerator;

	@PostMapping(path = "isbn")
	public String next() {
		return isbnGenerator.next();
	}
	
}
