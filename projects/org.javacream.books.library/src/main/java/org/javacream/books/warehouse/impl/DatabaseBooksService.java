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
import org.springframework.web.client.RestTemplate;

@Repository
@Transactional(rollbackFor = BookException.class)
public class DatabaseBooksService implements BooksService {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	@SequenceStrategy
	private IsbnGeneratorService isbnGenerator;
	@Autowired
	@Qualifier("withAuditing")
	private StoreService storeService;
	@Autowired @Qualifier("forContent")
	private RestTemplate restTemplate;

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
		entityManager.persist(book);
		return isbn;
	}

	public IsbnGeneratorService getIsbnGenerator() {
		return isbnGenerator;
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = entityManager.find(Book.class, isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}
		result.setAvailable(storeService.getStock("books", isbn) > 0);
		result.setContent(restTemplate.getForObject("http://localhost:9002/api/content/" + isbn , String.class));
		return result;
	}

	public Book updateBook(Book book) throws BookException {
		try {
			return entityManager.merge(book);
		} catch (RuntimeException e) {
			throw new BookException(BookExceptionType.NOT_FOUND, book.getIsbn());
		}
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		try {
			entityManager.remove(entityManager.getReference(Book.class, isbn));
		} catch (RuntimeException e) {
			throw new BookException(BookException.BookExceptionType.NOT_DELETED, isbn);
		}
	}

	public Collection<Book> findAllBooks() {
		return entityManager.createQuery("select b from Book as b", Book.class).getResultList();
	}

}
