package org.javacream.books.warehouse.web;

import java.util.Collection;
import java.util.stream.Collectors;

import org.javacream.books.content.ContentWebServiceReader;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
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
	private BooksService booksService;
	@Autowired
	private ContentWebServiceReader contentWebServiceReader;

	@PostMapping(path = "api/books/{title}")
	public String newBook(@PathVariable("title") String title) {
		try {
			return booksService.newBook(title);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@GetMapping(path = "api/books/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBookByIsbn(@PathVariable ("isbn") String isbn){
		try {
			return booksService.findBookByIsbn(isbn);
		}catch(BookException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(path = "api/books/content/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getContentForIsbn(@PathVariable ("isbn") String isbn){
		try {
			return contentWebServiceReader.getContentForIsbn(isbn);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "api/books", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBook(@RequestBody Book book) throws BookException {
		try {
		booksService.updateBook(book);
		}catch(BookException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@DeleteMapping(path = "api/books/{isbn}")
	public void deleteBookByIsbn(@PathVariable("isbn")String isbn) throws BookException {
		booksService.deleteBookByIsbn(isbn);
	}

	@GetMapping(path = "api/books", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<String> findAllIsbns() {
		return booksService.findAllBooks().stream().map((book ) -> book.getIsbn()).collect(Collectors.toList());
	}

}
