package org.javacream.app;

import javax.annotation.PostConstruct;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleApplication {
	@Autowired
	private BooksService booksService;

	@PostConstruct
	public void execute() {
		try {
			String isbn = booksService.newBook("Hugo");
			Book book = booksService.findBookByIsbn(isbn);
			System.out.println(book);
		} catch (BookException bookException) {
			bookException.printStackTrace();
		}
	}
}
