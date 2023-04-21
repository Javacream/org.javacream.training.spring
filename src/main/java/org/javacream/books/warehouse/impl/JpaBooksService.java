package org.javacream.books.warehouse.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksRepository;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;


@Repository
public class JpaBooksService implements BooksService {

	@Autowired
	@IsbnGenerator.SequenceStrategy
	private IsbnGenerator isbnGenerator;
	@Autowired @Qualifier("books") private Map<String, Book> books;
	@Autowired
	private StoreService storeService;
	@Autowired
	private BooksRepository booksRepository;
	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		booksRepository.save(book);
		return isbn;
	}

	public Book findBookByIsbn(String isbn) throws BookException {

		Optional<Book> result = booksRepository.findById(isbn);
		if (result.isPresent()) {
			Book book = result.get();
			book.setAvailable(storeService.getStock("books", isbn) > 0);
			return book;
		}
		throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);

	}

	public Book updateBook(Book bookValue) throws BookException {
		try {
			booksRepository.save(bookValue);
			return bookValue;
		} catch (RuntimeException e) {
			throw new BookException(BookException.BookExceptionType.CONSTRAINT, e.getMessage());
		}
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		try {
			booksRepository.deleteById(isbn);
		} catch (RuntimeException e) {
			throw new BookException(BookException.BookExceptionType.NOT_DELETED, e.getMessage());
		}
	}

	public Collection<Book> findAllBooks() {
		return booksRepository.findAll();
	}}
