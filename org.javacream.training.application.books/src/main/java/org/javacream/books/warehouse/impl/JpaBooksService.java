package org.javacream.books.warehouse.impl;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.jpa.BooksRepository;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Dr. Rainer Sawitzki
 * @company Javacream
 * @mailto rainer.sawitzki@javacream.org
 * 
 */
@Repository
public class JpaBooksService implements BooksService {

	public JpaBooksService() {
	}

	public JpaBooksService(IsbnGenerator isbngenerator, Map<String, Book> books, StoreService storeService) {
		super();
		this.isbnGenerator = isbngenerator;
		this.storeService = storeService;
	}

	@Autowired
	private IsbnGenerator isbnGenerator;

	// private Map<String, Book> books;

	@Autowired
	private BooksRepository booksRepository;
	@Autowired
	private StoreService storeService;

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		internalCall();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		booksRepository.save(book);
		return isbn;
	}

	public void internalCall() {
		System.out.println("newBook: internalCall");
	}

	public IsbnGenerator getIsbnGenerator() {
		return isbnGenerator;
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = booksRepository.findOne(isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}
		result.setAvailable(storeService.getStock("books", isbn) > 0);

		return SerializationUtils.clone(result);
	}

	public Book updateBook(Book bookValue) throws BookException {
		booksRepository.save(bookValue);
		return bookValue;
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		try {
			booksRepository.delete(booksRepository.findOne(isbn));
		} catch (RuntimeException re) {
			throw new BookException(BookException.BookExceptionType.NOT_DELETED, isbn);
		}

	}

	public Collection<Book> findAllBooks() {
		return booksRepository.findAll();
	}

}
