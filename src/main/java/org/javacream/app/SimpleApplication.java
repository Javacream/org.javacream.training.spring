package org.javacream.app;

import javax.annotation.PostConstruct;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class SimpleApplication {
	@Autowired
	private BooksService booksService;

	//@Autowired 
	private Book book;
	@PostConstruct
	public void execute() {
		try {
			System.out.println(booksService.findAllBooks());
			String isbn = booksService.newBook("Hugo");
			Book book = booksService.findBookByIsbn(isbn);
			System.out.println(book);
			System.out.println(this.book);
		} catch (BookException bookException) {
			bookException.printStackTrace();
		}
	}
}
