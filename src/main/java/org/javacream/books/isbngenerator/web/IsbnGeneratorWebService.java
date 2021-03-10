package org.javacream.books.isbngenerator.web;

import java.util.ArrayList;
import java.util.List;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.SequenceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsbnGeneratorWebService {

	@Autowired @SequenceStrategy private IsbnGeneratorService isbnGeneratorService;

	@PostMapping(path = "api/isbn", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> next(@RequestHeader("fetchSize") int fetchSize) {
		ArrayList<String> isbns = new ArrayList<String>(fetchSize);
		for (int i = 0; i < fetchSize; i++) {
			isbns.add(isbnGeneratorService.next());
		}
		return isbns;
	}
}
