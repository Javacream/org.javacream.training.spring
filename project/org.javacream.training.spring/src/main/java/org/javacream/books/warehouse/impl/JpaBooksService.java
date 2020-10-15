package org.javacream.books.warehouse.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.SequenceStrategy;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BookException.BookExceptionType;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaBooksService implements BooksService {

	@Autowired
	@SequenceStrategy
	private IsbnGeneratorService isbnGenerator;
	@Autowired
	@Qualifier("actor2")
	private StoreService storeService;
	@PersistenceContext
	private EntityManager entityManager;

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
		try {
			entityManager.persist(book);
			return isbn;
		} catch (RuntimeException e) {
			throw new BookException(BookExceptionType.NOT_CREATED, e.getMessage());
		}
	}

	public IsbnGeneratorService getIsbnGenerator() {
		return isbnGenerator;
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		try {
			Book result = entityManager.find(Book.class, isbn);
			result.setAvailable(storeService.getStock("books", isbn) > 0);
			return result;
		} catch (RuntimeException e) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}

	}

	public Book updateBook(Book bookValue) throws BookException {
		try {
			entityManager.merge(bookValue);
			return bookValue;
		} catch (RuntimeException e) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, bookValue.getIsbn());
		}
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		try {
			Book b = entityManager.find(Book.class, isbn);
			if (b == null) {
				throw new BookException(BookException.BookExceptionType.NOT_DELETED, isbn);
			} else {
				entityManager.remove(b);
			}
		} catch (RuntimeException e) {
			throw new BookException(BookException.BookExceptionType.NOT_DELETED, isbn);
		}
	}

	public Collection<Book> findAllBooks() {
		return entityManager.createQuery("select b from Book b", Book.class).getResultList();
	}

}
