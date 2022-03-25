package org.javacream.books.warehouse.web;

import java.util.List;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksRepositoryWebService {

	@Autowired private BooksRepository booksRepository;
	
	@GetMapping(path = "api/booksrepo", produces = MediaType.APPLICATION_JSON_VALUE) public List<Book> book(){
		return booksRepository.findAll();
	}
	@GetMapping(path = "api/booksrepo/title", produces = MediaType.APPLICATION_JSON_VALUE) public List<Book> booksByTitle(@RequestHeader("title") String title){
		return booksRepository.findByTitle(title);
	}
	
	@PostMapping(path = "api/booksrepo", consumes = MediaType.APPLICATION_JSON_VALUE) public void newBook(@RequestBody Book book) {
		booksRepository.save(book);
	}
}
