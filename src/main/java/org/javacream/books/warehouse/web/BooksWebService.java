package org.javacream.books.warehouse.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	@PostMapping(produces = MediaType.TEXT_PLAIN_VALUE, path = "api/books/{title}")
	public String newBook(@PathVariable("title") String title){
		try {
			return booksService.newBook(title);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "api/books/{isbn}")
	public Book findBookByIsbn(@PathVariable("isbn") String isbn) {
		try {
			return booksService.findBookByIsbn(isbn);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "api/books")
	public void updateBook(@RequestBody Book book){
		try {
			booksService.updateBook(book);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@DeleteMapping(path = "api/books/{isbn}")
	public void deleteBookByIsbn(String isbn) throws BookException {
		try {
			booksService.deleteBookByIsbn(isbn);
		} catch (BookException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "api/books")
	public List<String> findAllIsbns() {
		ArrayList<Book> books = new ArrayList<>(booksService.findAllBooks());
		return books.stream().map(b -> b.getIsbn()).collect(Collectors.toList());
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "api/books", consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Book> findAllBooksByIsbns(@RequestBody List<String> isbns) {
		ArrayList<Book> books = new ArrayList<>();
		isbns.forEach(isbn -> {
			try {
				books.add(booksService.findBookByIsbn(isbn));
			} catch (BookException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		});
		return books;
	}

}
