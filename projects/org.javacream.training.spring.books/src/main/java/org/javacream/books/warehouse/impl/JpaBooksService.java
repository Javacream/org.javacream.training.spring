package org.javacream.books.warehouse.impl;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBooksService implements BooksService {

	@Autowired
	@Qualifier("sequence")
	private IsbnGenerator isbnGenerator;

	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	@Autowired
	private StoreService storeService;
	@Autowired
	private BooksRepository booksRepository;

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
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}
		Book book = result.get();
		book.setAvailable(storeService.getStock("books", isbn) > 0);
		return book;
	}

	public Book updateBook(Book bookValue) throws BookException {
		booksRepository.save(bookValue);
		return bookValue;
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		try {
			booksRepository.deleteById(isbn);
		}catch(RuntimeException e) {
			throw new BookException(
					BookException.BookExceptionType.NOT_DELETED, isbn);
		}

	}

	public Collection<Book> findAllBooks() {
		return booksRepository.findAll().stream().map((Book b) -> {b.setAvailable(storeService.getStock("books", b.getIsbn()) > 0); return b;}).collect(Collectors.toList());
	}


}
