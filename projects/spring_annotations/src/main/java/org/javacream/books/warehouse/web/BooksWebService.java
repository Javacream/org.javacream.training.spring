package org.javacream.books.warehouse.web;

import java.util.Collection;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.BooksService.Cloning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BooksWebService {

	@Autowired
	@Cloning
	private BooksService booksService;

	@PostMapping(path = "api/books/{title}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String newBook(@PathVariable("title") String title) {
		try {
			return booksService.newBook(title);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@GetMapping(path = "api/books/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBookByIsbn(@PathVariable("isbn") String isbn) {
		try {
			return booksService.findBookByIsbn(isbn);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	// Hinweis zum ToDo: Hier konsumiert die Operation applicaion.json, und der
	// Parameter book wird im RequestBody gefunden
	@PutMapping(path = "api/books", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book updateBook(@RequestBody Book book) {
		try {
			return booksService.updateBook(book);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@DeleteMapping(path = "api/books/{isbn}")
	public void deleteBookByIsbn(@PathVariable("isbn") String isbn) {
		try {
			booksService.deleteBookByIsbn(isbn);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "api/books", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Book> findAllBooks() {
		return booksService.findAllBooks();
	}

}
