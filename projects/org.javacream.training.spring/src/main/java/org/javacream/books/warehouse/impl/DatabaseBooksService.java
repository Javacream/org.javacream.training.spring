package org.javacream.books.warehouse.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
@Transactional
public class DatabaseBooksService implements BooksService {

	@PersistenceContext private EntityManager entityManager;
	
	@Autowired
	@SequenceStrategy
	private IsbnGenerator isbnGenerator;
	@Autowired
	private StoreService storeService;

	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		entityManager.persist(book);
		return isbn;
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = entityManager.find(Book.class, isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}
		result.setAvailable(storeService.getStock("books", isbn) > 0);

		return result;
	}

	public Book updateBook(Book bookValue) throws BookException {
		return entityManager.merge(bookValue);
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		// 1) entityManager.remove(isbn);verführerisch, aber falsch
		// 2) entityManager.remove(entityManager.find(Book.class, isbn)); funktioniert, ist aber ziemlicher unfug
		// 3) entityManager.remove(entityManager.getReference(Book.class, isbn));//OK
//		4) Query query = entityManager.createQuery("delete b from BookEntity as b where b.isbn = :isbn");
//		4) query.setParameter("isbn", isbn);
//		4) query.executeUpdate();
		Query query = entityManager.createNativeQuery("delete from BOOKS where isbn = :isbn");
		query.setParameter("isbn", isbn);
		int affectedRows = query.executeUpdate();
		if (affectedRows != 1) {
			throw new BookException(BookException.BookExceptionType.NOT_DELETED, isbn);
		}
	}

	public Collection<Book> findAllBooks() {
		TypedQuery<Book> query = entityManager.createQuery("select b from BookEntity as b", Book.class);
		return query.getResultList();
	}
}
