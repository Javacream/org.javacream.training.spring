package org.javacream.books.warehouse.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class JpaBooksService implements BooksService {

	@Autowired
	@Qualifier(IsbnGenerator.SEQUENCE)
	private IsbnGenerator isbnGenerator;

	@PersistenceContext
	private EntityManager entityManager;//Dieser entityManager aus Sicht der Programmierung KEIN SINGLETON

	@Autowired
	private StoreService storeService;

	@Transactional
	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		entityManager.persist(book);
		return isbn;
	}

	@Transactional
	public Book findBookByIsbn(String isbn) throws BookException {
		try {
			Book result = entityManager.find(Book.class, isbn);
			result.setAvailable(storeService.getStock("books", isbn) > 0);
			return result;
		} catch (RuntimeException e) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}
	}
	@Transactional
	public Book updateBook(Book bookValue) throws BookException {
		entityManager.merge(bookValue);
		return bookValue;
	}

	@Transactional (rollbackFor=BookException.class) public void deleteBookByIsbn(String isbn) throws BookException {
		try {
			Book bookProxy = entityManager.getReference(Book.class, isbn);
			entityManager.remove(bookProxy);
		} catch (RuntimeException e) {
			throw new BookException(BookException.BookExceptionType.NOT_DELETED, isbn);
		}
	}
	@Transactional
	public Collection<Book> findAllBooks() {
		return entityManager.createQuery("select b from Book as b").getResultList();
	}

}