package org.javacream.books.warehouse.impl.decorators;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;

public class CloningBooksService extends BaseDecorator{

	@Override
	public Book findBookByIsbn(String isbn) throws BookException {
		return SerializationUtils.clone(delegate.findBookByIsbn(isbn));
	}

	@Override
	public Book updateBook(Book book) throws BookException {
		return delegate.updateBook(SerializationUtils.clone(book));
	}

	@Override
	public Collection<Book> findAllBooks() {
		return SerializationUtils.clone(new ArrayList<Book>(delegate.findAllBooks()));
	}

}
