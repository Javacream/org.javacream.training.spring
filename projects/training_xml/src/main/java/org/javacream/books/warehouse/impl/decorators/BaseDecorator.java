package org.javacream.books.warehouse.impl.decorators;

import java.util.Collection;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;

public abstract class BaseDecorator implements BooksService{
	protected BooksService delegate;

	public String newBook(String title) throws BookException {
		return delegate.newBook(title);
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		return delegate.findBookByIsbn(isbn);
	}

	public Book updateBook(Book book) throws BookException {
		return delegate.updateBook(book);
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		delegate.deleteBookByIsbn(isbn);
	}

	public Collection<Book> findAllBooks() {
		return delegate.findAllBooks();
	}

	public void setDelegate(BooksService delegate) {
		this.delegate = delegate;
	}
	
	
	

}
