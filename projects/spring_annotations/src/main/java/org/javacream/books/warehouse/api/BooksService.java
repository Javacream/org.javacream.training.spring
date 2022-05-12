package org.javacream.books.warehouse.api;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;


public interface BooksService{
	String newBook(String title) throws BookException;

	Book findBookByIsbn(String isbn) throws BookException;
	
	Book updateBook(Book book) throws BookException;
	
	void deleteBookByIsbn(String isbn) throws BookException;
	
	Collection<Book> findAllBooks();
	
	@Retention(RUNTIME)
	@Target({ TYPE, FIELD, METHOD, PARAMETER })
	@Qualifier
	public @interface InMemory {

	}

	@Retention(RUNTIME)
	@Target({ TYPE, FIELD, METHOD, PARAMETER })
	@Qualifier
	public @interface Cloning{

	}
}
