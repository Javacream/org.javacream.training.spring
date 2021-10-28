package org.javacream.books.warehouse.decorators;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CloningBooksService implements BooksService{
	@Autowired private BooksService delegate;

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
		return SerializationUtils.clone(new ArrayList<>(delegate.findAllBooks()));
	}

}
