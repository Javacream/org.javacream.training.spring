package org.javacream.books.warehouse.web;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksRepositoryWebService {

	@Autowired BooksRepository booksRepository;
	
	@PostMapping(path="api/booksrepo", consumes = MediaType.APPLICATION_JSON_VALUE) public void insertBook(@RequestBody Book b) {
		booksRepository.save(b);

	}
}
