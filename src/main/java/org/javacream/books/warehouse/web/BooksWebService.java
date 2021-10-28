package org.javacream.books.warehouse.web;

import java.util.Collection;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BooksWebService {

	@Autowired private BooksService booksService;


	public String newBook(String title) throws BookException {
		return booksService.newBook(title);
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		return booksService.findBookByIsbn(isbn);
	}

	@PutMapping(path = "api/books/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book updateBook(@PathVariable("isbn") String isbn, @RequestBody Book book){
		try {
			return booksService.updateBook(book);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
		}
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		booksService.deleteBookByIsbn(isbn);
	}

	public Collection<Book> findAllBooks() {
		return booksService.findAllBooks();
	}
}
