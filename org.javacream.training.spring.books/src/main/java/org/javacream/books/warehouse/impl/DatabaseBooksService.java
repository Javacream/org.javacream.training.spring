package org.javacream.books.warehouse.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DatabaseBooksService implements BooksService {

	@Autowired
	@SequenceStrategy
	private IsbnGenerator isbnGenerator;
	@Autowired
	private StoreService storeService;

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		entityManager.persist(book);
		return isbn;
	}

	public IsbnGenerator getIsbnGenerator() {
		return isbnGenerator;
	}

	@Transactional
	public Book findBookByIsbn(String isbn) throws BookException {
		try {
			Book result = entityManager.find(Book.class, isbn);
			result.setAvailable(storeService.getStock("books", isbn) > 0);
			return result;
		} catch (NullPointerException e) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}
	}

	@Transactional
	public Book updateBook(Book bookValue) throws BookException {
		try {
			entityManager.merge(bookValue);
			return bookValue;
		} catch (Exception nre) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, bookValue.getIsbn());
		}
	}

	@Transactional
	public void deleteBookByIsbn(String isbn) throws BookException {
			Book toDelete = entityManager.find(Book.class, isbn);
			if (toDelete == null){
				throw new BookException(BookException.BookExceptionType.NOT_DELETED, isbn);
				
			}
			entityManager.remove(toDelete);
	}

	public Collection<Book> findAllBooks() {
		TypedQuery<Book> query = entityManager.createQuery("select b from Book as b", Book.class);
		return query.getResultList();
	}

}
