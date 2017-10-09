package org.javacream.books.warehouse.impl;

import java.util.Collection;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BookException.BookExceptionType;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.jpa.BookRepository;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dr. Rainer Sawitzki
 * @company Javacream
 * @mailto rainer.sawitzki@javacream.org
 * 
 */
@Repository
@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor=BookException.class)
public class JpaBooksService implements BooksService {

	@Autowired
	private IsbnGenerator isbnGenerator;
	@Autowired
	private StoreService storeService;

	@Autowired
	private BookRepository bookRepository;

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
		bookRepository.save(book);
		return isbn;
	}

	public IsbnGenerator getIsbnGenerator() {
		return isbnGenerator;
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = (Book) bookRepository.findOne(isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}
		result.setAvailable(storeService.getStock("books", isbn) > 0);

		return result;
	}

	public Book updateBook(Book bookValue) throws BookException {
		bookRepository.save(bookValue);
		return bookValue;
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		try{
		bookRepository.delete(isbn);
		}catch(RuntimeException e){
			throw new BookException(BookExceptionType.NOT_DELETED, e.getMessage());
		}
	}

	public Collection<Book> findAllBooks() {
		return bookRepository.findAll();
	}
}
