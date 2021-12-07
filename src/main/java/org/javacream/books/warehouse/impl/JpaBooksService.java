package org.javacream.books.warehouse.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.SequenceStrategy;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.repository.BooksRepository;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBooksService implements BooksService {

	@Autowired
	@SequenceStrategy
	private IsbnGeneratorService isbnGenerator;

	// @Autowired private Map<String, Book> books;

	@Autowired
	private BooksRepository booksRepository;

	@Autowired
	private StoreService storeService;

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public void setIsbnGenerator(IsbnGeneratorService isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		booksRepository.save(book);
		return isbn;
	}

	public IsbnGeneratorService getIsbnGenerator() {
		return isbnGenerator;
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		Optional<Book> result = booksRepository.findById(isbn);
		if (result.isEmpty()) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}
		Book found = result.get();
		found.setAvailable(storeService.getStock("books", isbn) > 0);

		return found;
	}

	public Book updateBook(Book bookValue) throws BookException {
		booksRepository.save(bookValue);
		return bookValue;
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		try {
			booksRepository.deleteById(isbn);
		} catch (RuntimeException e) {
			throw new BookException(BookException.BookExceptionType.NOT_DELETED, isbn);
		}
	}

	public Collection<Book> findAllBooks() {
		return new ArrayList<>(booksRepository.findAll());
	}


}
