package org.javacream.books.warehouse.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Repository
public class MapBooksService implements BooksService {

	@Autowired
	@IsbnGenerator.SequenceStrategy
	private IsbnGenerator isbnGenerator;
	private Map<String, Book> books; //TODO: Ist das auch eine Spring Dependency? -> später
	@Autowired
	private StoreService storeService;
	
	{
		books = new HashMap<String, Book>();
	}

	@PostConstruct
	public void initIt(){
		System.out.println("initializing " + this + ", isbngenerator=" + this.isbnGenerator);

	}

	@PreDestroy
	public void cleanUp(){
		System.out.println("destroying " + this + ", isbngenerator=" + this.isbnGenerator);

	}

	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		books.put(isbn, book);
		return isbn;
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = (Book) books.get(isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND,
					isbn);
		}
		result.setAvailable(storeService.getStock("books", isbn) > 0);
		
		return SerializationUtils.clone(result);
	}

	public Book updateBook(Book bookValue) throws BookException {
		books.put(bookValue.getIsbn(), SerializationUtils.clone(bookValue)); 
		return bookValue;
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		Object result = books.remove(isbn);
		if (result == null) {
			throw new BookException(
					BookException.BookExceptionType.NOT_DELETED, isbn);
		}
	}


	public Collection<Book> findAllBooks() {
		return SerializationUtils.clone(new ArrayList<Book>(books.values()));
	}
}
