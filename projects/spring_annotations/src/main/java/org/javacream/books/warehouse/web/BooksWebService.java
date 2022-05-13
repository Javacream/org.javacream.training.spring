package org.javacream.books.warehouse.web;

import java.util.Collection;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.BooksService.Cloning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksWebService {

	@Autowired @Cloning private BooksService booksService;

	@PostMapping(path="api/books/{title}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String newBook(@PathVariable("title") String title) throws BookException {
		return booksService.newBook(title);
	}

	
	@GetMapping(path="api/books/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBookByIsbn(@PathVariable("isbn")  String isbn) throws BookException {
		return booksService.findBookByIsbn(isbn);
	}
	//Hinweis zum ToDo: Hier konsumiert die Operation applicaion.json, und der Parameter book wird im RequestBody gefunden
	public Book updateBook(Book book) throws BookException {
		return booksService.updateBook(book);
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		booksService.deleteBookByIsbn(isbn);
	}

	public Collection<Book> findAllBooks() {
		return booksService.findAllBooks();
	}
	
	
}
