package org.javacream.books.warehouse.api.test;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BooksServiceTest {

	@Autowired BooksService booksService;
	
	@Test public void createBookReturnsIsbn() throws BookException {
		Assertions.assertNotNull(booksService.newBook("title"));
	}
	@Test public void createdBookIsBeFound() throws BookException {
		final String TITLE = "title"; 
		String isbn = booksService.newBook(TITLE);
		Book book = booksService.findBookByIsbn(isbn);
		Assertions.assertEquals(TITLE, book.getTitle());
	}
	@Test public void createdBookCanBeDeleted() throws BookException {
		final String TITLE = "title"; 
		String isbn = booksService.newBook(TITLE);
		booksService.deleteBookByIsbn(isbn);
	}
}
