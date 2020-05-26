package org.javacream.books.warehouse.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BookException.BookExceptionType;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {BookException.class} )
public class JpaBooksService implements BooksService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	@IsbnGenerator.RandomStrategy
	private IsbnGenerator isbnGenerator;
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
		entityManager.persist(book);
		return isbn;
	}

	public IsbnGenerator getIsbnGenerator() {
		return isbnGenerator;
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = entityManager.find(Book.class, isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}
		result.setAvailable(storeService.getStock("books", isbn) > 0);

		return result;
	}

	public Book updateBook(Book book) throws BookException {
		entityManager.merge(book);
		return book;
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		// Book toDelete = entityManager.find(Book.class, isbn); -> falsch: Buch zum
		// Löschen komplett laden???
		Book toDelete = entityManager.getReference(Book.class, isbn); // So ists richtig
//		//Alternativ: Native Query
//		Query query = entityManager.createNativeQuery("delete from BOOK_TABLE where isbn=:isbn");
//		query.setParameter("isbn", isbn);
//		query.executeUpdate();
		try {
			entityManager.remove(toDelete);
		} catch (EntityNotFoundException e) {
			throw new BookException(BookExceptionType.NOT_DELETED, e.getMessage());
			//throw new RuntimeException(e.getMessage());
		}
	}

	public Collection<Book> findAllBooks() {
		String jpaQuery = "select book from BookEntity as book";
		return entityManager.createQuery(jpaQuery, Book.class).getResultList();
	}

}
