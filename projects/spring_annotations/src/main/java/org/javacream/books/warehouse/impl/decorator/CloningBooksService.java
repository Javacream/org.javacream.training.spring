package org.javacream.books.warehouse.impl.decorator;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.BooksService.Cloning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Cloning
public class CloningBooksService implements BooksService{
	@Autowired @InMemory private BooksService delegate;

	public String newBook(String title) throws BookException {
		return delegate.newBook(title);
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = delegate.findBookByIsbn(isbn); 
		return SerializationUtils.clone(result);
	}

	public Book updateBook(Book book) throws BookException {
		return delegate.updateBook(SerializationUtils.clone(book));
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		delegate.deleteBookByIsbn(isbn);
	}

	public Collection<Book> findAllBooks() {
		Collection<Book> books = delegate.findAllBooks();
		return SerializationUtils.clone(new ArrayList<>(books));
	}

	public void setDelegate(BooksService delegate) {
		this.delegate = delegate;
	}

}
