package org.javacream.books.warehouse.test;

import java.util.Collection;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Assertions;

public class TestActor {

	public static void doTest(BooksService booksService) {
		try {
			Collection<Book> books = booksService.findAllBooks();
			final int startSize = books.size();
			String j2eeTitle = "Spring";
			String isbn = booksService.newBook(j2eeTitle);
			books = booksService.findAllBooks();
			final int endSize = books.size();
			Assertions.assertTrue(endSize == startSize + 1);
			Assertions.assertNotNull(isbn);
			Assertions.assertNotNull(booksService.findBookByIsbn(isbn));

			try {
				booksService.findBookByIsbn("ISBN-3");
				Assertions.fail("BookException must be thrown!");
			} catch (BookException e) {
				// OK
			}
			booksService.deleteBookByIsbn(isbn);
			Assertions.assertTrue(startSize == booksService.findAllBooks().size());
			try {
				booksService.deleteBookByIsbn(isbn);
				Assertions.fail("BookException must be thrown!");
			} catch (BookException e) {
				// OK
			}

		} catch (BookException bookException) {
			bookException.printStackTrace();
			Assertions.fail(bookException.getMessage());
		}

	}

}
