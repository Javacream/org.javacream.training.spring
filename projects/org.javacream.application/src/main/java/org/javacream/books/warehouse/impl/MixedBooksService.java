package org.javacream.books.warehouse.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.SequenceStrategy;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BookException.BookExceptionType;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.BooksService.MixedStrategy;
import org.javacream.books.warehouse.repository.BooksRepository;
import org.javacream.logger.LogService;
import org.javacream.store.api.StoreService;
import org.javacream.util.aspects.Traced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@MixedStrategy
public class MixedBooksService implements BooksService {

	@Autowired
	private BooksRepository booksRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	@SequenceStrategy
	private IsbnGeneratorService isbnGenerator;

	@Autowired
	private LogService logService;
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
		try {
			logService.log("created book " + isbn);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		return isbn;
	}

	public IsbnGeneratorService getIsbnGenerator() {
		return isbnGenerator;
	}

	@Traced
	public Book findBookByIsbn(String isbn) throws BookException {

		Book result = entityManager.find(Book.class, isbn);
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
		Query query = entityManager.createNativeQuery("delete from BOOK  where isbn=:isbn");
		query.setParameter("isbn", isbn);
		int i = query.executeUpdate();
		if (i == 0) {
			throw new BookException(BookExceptionType.NOT_DELETED, isbn);
		}
	}

	@Traced
	public Collection<Book> findAllBooks() {
		return booksRepository.findAll();
	}

}
