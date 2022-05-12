package org.javacream.books.warehouse.impl;

import java.util.Collection;
import java.util.Map;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.BooksService.InMemory;
import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@InMemory
public class MapBooksServiceImpl implements BooksService {

	@Autowired @SequenceStrategy private IsbnGenerator isbnGenerator;
	@Autowired @Qualifier("booksData") private Map<String, Book> books;
	@Autowired @Audited private StoreService storeService;

	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		books.put(isbn, book);
		return isbn;
	}

	public IsbnGenerator getIsbnGenerator() {
		return isbnGenerator;
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

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
		
	}
	
}
