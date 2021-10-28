package org.javacream.books.warehouse.api;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
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
	@Target({ TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
	@Qualifier
	public @interface EntityManagerStrategy {

	}
	@Retention(RUNTIME)
	@Target({ TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
	@Qualifier
	public @interface RepositoryStrategy {

	}
}
