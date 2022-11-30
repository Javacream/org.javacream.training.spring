package org.javacream.books.warehouse.web;

import java.util.Collection;
import java.util.stream.Collectors;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksWebService {

	@Autowired
	private BooksService booksService;

	@PostMapping(path = "api/book/{title}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String newBook(@PathVariable("title") String title) throws BookException {
		return booksService.newBook(title);
	}

	@GetMapping(path = "api/book/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBookByIsbn(@PathVariable("isbn") String isbn) throws BookException {
		return booksService.findBookByIsbn(isbn);
	}

	@PutMapping(path = "api/books/price")
	public void updatePrice(@RequestHeader("isbn") String isbn, @RequestHeader("price") double price)
			throws BookException {
		Book b = findBookByIsbn(isbn);
		b.setPrice(price);
		booksService.updateBook(b);
	}

	@PutMapping(path = "api/books/title")
	public void updateTitle(@RequestHeader("isbn") String isbn, @RequestHeader("title") String title)
			throws BookException {
		Book b = findBookByIsbn(isbn);
		b.setTitle(title);
		booksService.updateBook(b);
	}

	@DeleteMapping(path = "api/book/{isbn}")
	public void deleteBookByIsbn(String isbn) throws BookException {
		booksService.deleteBookByIsbn(isbn);
	}

	@GetMapping(path = "api/book")
	public Collection<String> findAllBooks() {
		return booksService.findAllBooks().stream().map(b -> b.getIsbn()).collect(Collectors.toList());
	}
}
