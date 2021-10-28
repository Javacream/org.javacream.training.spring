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
import org.javacream.books.warehouse.api.BooksService.EntityManagerStrategy;
import org.javacream.store.api.StoreService;
import org.javacream.util.aspects.Traced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@EntityManagerStrategy
public class EntityManagerBooksService implements BooksService {

	@PersistenceContext
	private EntityManager entityManager;
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
		entityManager.persist(book);
		return isbn;
	}

	public IsbnGeneratorService getIsbnGenerator() {
		return isbnGenerator;
	}

	@Traced
	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = entityManager.find(Book.class, isbn);
		if (result == null) {
			throw new BookException(BookExceptionType.NOT_FOUND, isbn);
		} else {
			result.setAvailable((storeService.getStock("books", isbn) > 0));
			return result;
		}
	}

	@Traced
	public Book updateBook(Book book) throws BookException {
		return entityManager.merge(book);
	}

	@Traced
	public void deleteBookByIsbn(String isbn) throws BookException {
		Book b = entityManager.getReference(Book.class, isbn);
		entityManager.remove(b);
	}

	@Traced
	public Collection<Book> findAllBooks() {
		return entityManager.createQuery("select b from Book as b", Book.class).getResultList();
	}

}
