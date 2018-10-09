package org.javacream.books.warehouse.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class MapBooksService implements BooksService {

	@Autowired @Qualifier(IsbnGenerator.RANDOM)
	private IsbnGenerator randomIsbnGenerator;
	private Map<String, Book> books;
	@Autowired
	private StoreService storeService;
	
	{
		books = new HashMap<String, Book>();
	}

	
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}


	public String newBook(String title) throws BookException {
		String isbn = randomIsbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		books.put(isbn, book);
		return isbn;
	}

	public IsbnGenerator getIsbnGenerator() {
		return randomIsbnGenerator;
	}
	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = (Book) books.get(isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND,
					isbn);
		}
		result.setAvailable(storeService.getStock("books", isbn) > 0);
		
		return result;
	}

	public Book updateBook(Book bookValue) throws BookException {
		books.put(bookValue.getIsbn(), bookValue); 
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
		return books.values();
	}
	public void setBooks(Map<String, Book> books) {
		this.books = books;
	}
	
}
