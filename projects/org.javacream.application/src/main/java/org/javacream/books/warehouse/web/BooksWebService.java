package org.javacream.books.warehouse.web;

import java.util.Collection;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.BooksService.EntityManagerStrategy;
import org.javacream.books.warehouse.api.BooksService.RepositoryStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BooksWebService {

	@Autowired
	@EntityManagerStrategy
	private BooksService entityManagerBooksService;
	@Autowired
	@RepositoryStrategy
	private BooksService repositoryBooksService;

	private BooksService forStrategy(String strategy) {
		if ("entityManager".equals(strategy)) {
			return entityManagerBooksService;
		} else {
			return repositoryBooksService;
		}
	}

	@PostMapping(path = "api/books/{title}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String newBook(@PathVariable("title") String title,
			@RequestHeader(value = "strategy", defaultValue = "entityManager") String strategy) {
		BooksService booksService = forStrategy(strategy);
		try {
			return booksService.newBook(title);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
		}
	}

	@GetMapping(path = "api/books/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBookByIsbn(@PathVariable("isbn") String isbn,
			@RequestHeader(value = "strategy", defaultValue = "entityManager") String strategy) {
		BooksService booksService = forStrategy(strategy);
		try {
			return booksService.findBookByIsbn(isbn);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PutMapping(path = "api/books/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book updateBook(@PathVariable("isbn") String isbn, @RequestBody Book book,
			@RequestHeader(value = "strategy", defaultValue = "entityManager") String strategy) {
		BooksService booksService = forStrategy(strategy);
		try {
			return booksService.updateBook(book);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
		}
	}

	@DeleteMapping(path = "api/books/{isbn}")
	public void deleteBookByIsbn(@PathVariable("isbn") String isbn,
			@RequestHeader(value = "strategy", defaultValue = "entityManager") String strategy) {
		BooksService booksService = forStrategy(strategy);
		try {
			booksService.deleteBookByIsbn(isbn);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
		}
	}

	@GetMapping(path = "api/books", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Book> findAllBooks(
			@RequestHeader(value = "strategy", defaultValue = "entityManager") String strategy) {
		BooksService booksService = forStrategy(strategy);
		return booksService.findAllBooks();
	}
}
