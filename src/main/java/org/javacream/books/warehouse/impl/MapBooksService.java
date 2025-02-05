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


@Repository
public class MapBooksService implements BooksService {

	@Autowired
	@IsbnGenerator.RandomStrategy private IsbnGenerator isbngenerator;
	private Map<String, Book> books;
	@Autowired
	private StoreService storeService;
	
	{
		books = new HashMap<String, Book>();
		String isbn = "ISBN1";
		books.put(isbn, new Book(isbn, "Title", 19.99, 200, true));
	}
	public String newBook(String title) throws BookException {
		String isbn = isbngenerator.next();
		Book book = new Book(isbn, title);
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
	public void setBooks(Map<String, Book> books) {
		this.books = books;
	}
	
}
