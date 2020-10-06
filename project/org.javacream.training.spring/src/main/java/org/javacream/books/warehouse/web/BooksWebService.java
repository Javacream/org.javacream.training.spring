package org.javacream.books.warehouse.web;

import java.util.Collection;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BooksWebService {

	@Autowired private BooksService booksService;

	//TODO: Exception-Handling-> BookException HttpStatus
	
	@PostMapping(path="api/books{title}")
	public String newBook(@PathVariable("title") String title){
		try {
			return booksService.newBook(title);
		}
		catch(BookException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	//produces application/json  (Spring MVC hat eine Standard-Encodoerung nach JSON
	@GetMapping(path = "api/books/{isbn}", produces = "application/json")
	public Book findBookByIsbn(@PathVariable ("isbn") String isbn) throws BookException {
		return booksService.findBookByIsbn(isbn);
	}

	
	public void updateBook(Book book) throws BookException {
		booksService.updateBook(book);
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		booksService.deleteBookByIsbn(isbn);
	}

	public Collection<String> findAllSIbns() {
		return booksService.findAllBooks();
	}
	
	
}
