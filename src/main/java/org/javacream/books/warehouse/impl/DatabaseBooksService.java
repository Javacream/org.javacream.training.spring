package org.javacream.books.warehouse.impl;

import java.util.Collection;
import java.util.Optional;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BookException.BookExceptionType;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseBooksService implements BooksService {

	@Autowired
	private IsbnGenerator isbnGenerator;

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
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		booksRepository.save(book);
		return isbn;
	}

	public IsbnGenerator getIsbnGenerator() {
		return isbnGenerator;
	}

	public Book findBookByIsbn(String isbn) throws BookException {

		Optional<Book> result = booksRepository.findById(isbn);
		if (result.isEmpty()) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}
		Book book = result.get();
		book.setAvailable(storeService.getStock("books", isbn) > 0);

		return book;
	}

	public Book updateBook(Book bookValue) throws BookException {
		try {
			booksRepository.save(bookValue);
			return bookValue;
		} catch (RuntimeException e) {
			throw new BookException(BookExceptionType.CONSTRAINT, e.getMessage());
		}
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		try {
			booksRepository.deleteById(isbn);
		} catch (RuntimeException e) {
			throw new BookException(BookExceptionType.NOT_DELETED, e.getMessage());
		}
	}

	public Collection<Book> findAllBooks() {
		return booksRepository.findAll();
	}

}
