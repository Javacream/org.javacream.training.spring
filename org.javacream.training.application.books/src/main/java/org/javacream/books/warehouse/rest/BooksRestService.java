package org.javacream.books.warehouse.rest;

import java.util.Collection;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksRestService {

	@Autowired
	private BooksService booksService;

	@RequestMapping(method = RequestMethod.POST, path = "/books/{title}")
	public String insert(@PathVariable("title") String title) {

		try {
			return booksService.newBook(title);
		} catch (BookException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/books")
	public Collection<Book> findAll() {

		return booksService.findAllBooks();
	}
}
