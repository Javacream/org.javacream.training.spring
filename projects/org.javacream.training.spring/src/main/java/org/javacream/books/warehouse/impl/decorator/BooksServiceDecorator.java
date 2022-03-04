package org.javacream.books.warehouse.impl.decorator;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;

public class BooksServiceDecorator implements BooksService{
	@Autowired BooksService booksService;

	public String newBook(String title) throws BookException {
		return booksService.newBook(title);
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		return SerializationUtils.clone(booksService.findBookByIsbn(isbn));
	}

	public Book updateBook(Book book) throws BookException {
		return SerializationUtils.clone(booksService.updateBook(SerializationUtils.clone(book)));
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		booksService.deleteBookByIsbn(isbn);
	}

	public Collection<Book> findAllBooks() {
		return SerializationUtils.clone(new ArrayList<Book>(booksService.findAllBooks()));
	}

}
