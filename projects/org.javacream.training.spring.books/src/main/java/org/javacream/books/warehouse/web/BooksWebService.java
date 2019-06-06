package org.javacream.books.warehouse.web;

import java.util.Collection;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksWebService {

	@Autowired private BooksService booksService;

	@GetMapping(path = "books")
	public Collection<Book> findAllBooks() {
		return booksService.findAllBooks();
	}
}
