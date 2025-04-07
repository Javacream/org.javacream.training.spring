package org.javacream.books.warehouse.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.store.ReadingStoreService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksRepository;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;


@Repository
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = BookException.class)
public class DatabaseBooksService implements BooksService {

	@Autowired
	@IsbnGenerator.SequenceStrategy
	private IsbnGenerator isbnGenerator;
	@Autowired
	ReadingStoreService readingStoreService;
	@Autowired
	private BooksRepository booksRepository;
	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = new Book(isbn, title, 19.99, 200, false);
		booksRepository.save(book);
		throw new BookException(BookException.BookExceptionType.TECHNICAL, "TEST");
		//throw new RuntimeException("TEST");
		//return isbn;
	}

	public Book findBookByIsbn(String isbn) throws BookException {

		Optional<Book> result = booksRepository.findById(isbn);
		if (result.isPresent()) {
			Book book = result.get();
			book.setAvailable(readingStoreService.getStock(isbn) > 0);
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
		if (booksRepository.existsById(isbn)) {
			booksRepository.deleteById(isbn);
		}
		else {
			throw new BookException(BookException.BookExceptionType.NOT_DELETED, "isbn does not exist");
		}
	}

	public Collection<Book> findAllBooks() {
		return booksRepository.findAll();
	}}