package org.javacream.books.warehouse.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BookException.BookExceptionType;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class DatabaseBooksServiceImpl implements BooksService {

	@Autowired @SequenceStrategy private IsbnGenerator isbnGenerator;
	@Autowired private StoreService storeService;
	@PersistenceContext private EntityManager entityManager;
	
	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	@Transactional(rollbackFor = BookException.class)
	public String newBook(String title) throws BookException {
//		if (title == null || title.length() < 2) {
//			throw new BookException(BookExceptionType.NOT_CREATED, "invalid title: " + title);
//		}
		String isbn = isbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		entityManager.persist(book);
		//Hier unsinnig, soll aber das funktionierende Rollback-Verhalten zeigen
		if (title == null || title.length() < 2) {
			throw new BookException(BookExceptionType.NOT_CREATED, "invalid title: " + title);
		}

		return isbn;
	}

	public IsbnGenerator getIsbnGenerator() {
		return isbnGenerator;
	}
	@Transactional
	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = entityManager.find(Book.class, isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND,
					isbn);
		}
		setAvailability(result);
		return result;
	}

	private Book setAvailability(Book book) {
		book.setAvailable(storeService.getStock("books", book.getIsbn()) > 0);
		return book;
		
	}
	@Transactional
	public Book updateBook(Book bookValue) throws BookException {
		entityManager.merge(bookValue); 
		return bookValue;
	}

	@Transactional
	public void deleteBookByIsbn(String isbn) throws BookException {
		Book toDeleteProxy = entityManager.getReference(Book.class, isbn);
		try{
			entityManager.remove(toDeleteProxy);
		}
		catch(RuntimeException e) {
			throw new BookException(
					BookException.BookExceptionType.NOT_DELETED, isbn);
			
		}
	}


	@Transactional
	public Collection<Book> findAllBooks() {
		return entityManager.createQuery("select b from Book as b", Book.class).getResultList().stream().map(this::setAvailability).collect(Collectors.toList());
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
		
	}
	
}
