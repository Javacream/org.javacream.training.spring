package org.javacream.books.warehouse.web;

import java.util.List;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksWebRepository {

	@Autowired BooksRepository booksRepository;
	
	@GetMapping(path = "booksrepo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> findAll() {
		return booksRepository.findAll();
	}
}
