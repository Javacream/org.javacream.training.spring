package org.javacream.books.warehouse.decorators;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;

public class CloningBooksService implements BooksService{
	private BooksService delegate;

	public String newBook(String title) throws BookException {
		return delegate.newBook(title);
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		return SerializationUtils.clone(delegate.findBookByIsbn(isbn));
	}

	public Book updateBook(Book book) throws BookException {
		return delegate.updateBook(SerializationUtils.clone(book));
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		delegate.deleteBookByIsbn(isbn);
	}

	public Collection<Book> findAllBooks() {
		return SerializationUtils.clone(new ArrayList(findAllBooks()));
	}

}
