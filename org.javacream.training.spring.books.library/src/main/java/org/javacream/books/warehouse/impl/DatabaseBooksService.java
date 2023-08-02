package org.javacream.books.warehouse.impl;

import java.util.Collection;
import java.util.Optional;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.store.StoreRequestor;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksRepository;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(rollbackFor = {BookException.class})
public class DatabaseBooksService implements BooksService {

	@Autowired
	private RandomIsbnGenerator isbnGenerator;
	@Autowired
	private BooksRepository booksRepository;
	@Autowired
	private StoreRequestor storeRequestor;

	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		booksRepository.save(book);
		return isbn;
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		Optional<Book> result = booksRepository.findById(isbn);
		if (!result.isPresent()) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND,
					isbn);
		}
		Book resultBook = result.get();
		resultBook.setAvailable(storeRequestor.getStock("books", isbn) > 0);
		
		return resultBook;
	}

	public Book updateBook(Book bookValue) throws BookException {
		try {
			booksRepository.save(bookValue);
			return bookValue;
		}
		catch(RuntimeException e){
			throw new BookException(BookException.BookExceptionType.CONSTRAINT, e.getMessage());
		}
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		try {
			booksRepository.deleteById(isbn);
		}
		catch(RuntimeException e){
			throw new BookException(
					BookException.BookExceptionType.NOT_DELETED, e.getMessage());
		}

	}


	public Collection<Book> findAllBooks() {
		return booksRepository.findAll();
	}
}
