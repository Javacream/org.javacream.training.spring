package org.javacream.books.warehouse.web;

import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BooksWebService {
	@Autowired private BooksService booksService;

	@PostMapping(path="books/{title}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String newBook(@PathVariable("title") String title){
		try {
			return booksService.newBook(title);
		} catch (BookException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	
}
