package org.javacream.books.warehouse.impl;

import java.util.Collection;
import java.util.Optional;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.SequenceStrategy;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BookException.BookExceptionType;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.BooksService.RepositoryStrategy;
import org.javacream.books.warehouse.repository.BooksRepository;
import org.javacream.store.api.StoreService;
import org.javacream.util.aspects.Traced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RepositoryStrategy
public class BooksRepositoryBooksService implements BooksService {

	@Autowired
	private BooksRepository booksRepository;

	@Autowired
	@SequenceStrategy
	private IsbnGeneratorService isbnGenerator;

	@Autowired
	private StoreService storeService;

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public void setIsbnGenerator(IsbnGeneratorService isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	@Traced
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

	@Traced
	public Book findBookByIsbn(String isbn) throws BookException {

		Optional<Book> optionalResult = booksRepository.findById(isbn);
		Book result = optionalResult.orElseThrow(() -> new BookException(BookExceptionType.NOT_FOUND, isbn));
		result.setAvailable(storeService.getStock("books", isbn) > 0);
		return result;
	}

	@Traced
	public Book updateBook(Book book) throws BookException {
		if (!booksRepository.existsById(book.getIsbn())) {
			throw new BookException(BookExceptionType.NOT_FOUND, book.getIsbn());
		}
		booksRepository.save(book);
		return book;
	}

	@Traced
	public void deleteBookByIsbn(String isbn) throws BookException {
		if (!booksRepository.existsById(isbn)) {
			throw new BookException(BookExceptionType.NOT_DELETED, isbn);
		}

		booksRepository.deleteById(isbn);
	}

	@Traced
	public Collection<Book> findAllBooks() {
		return booksRepository.findAll();
	}

}
