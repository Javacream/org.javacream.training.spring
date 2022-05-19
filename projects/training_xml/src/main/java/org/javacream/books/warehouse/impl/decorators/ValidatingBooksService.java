package org.javacream.books.warehouse.impl.decorators;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BookException.BookExceptionType;

public class ValidatingBooksService extends BaseDecorator {

	@Override
	public String newBook(String title) throws BookException {
		if (title != null && title.trim().length() > 0) {
			return delegate.newBook(title);
		} else {
			throw new BookException(BookExceptionType.CONSTRAINT, "invalid title: " + title);
		}
	}

	@Override
	public Book updateBook(Book book) throws BookException {
		double price = book.getPrice();
		if (price >= 0) {
			return delegate.updateBook(book);
		} else {
			throw new BookException(BookExceptionType.CONSTRAINT, "invalid price: " + price);
		}
	}

}
