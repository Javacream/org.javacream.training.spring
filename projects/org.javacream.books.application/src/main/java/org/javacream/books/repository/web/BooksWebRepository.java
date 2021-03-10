package org.javacream.books.repository.web;

import java.util.Optional;

import org.javacream.books.repository.api.BookEntity;
import org.javacream.books.repository.api.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BooksWebRepository {
	
	@Autowired private BooksRepository booksRepository;
	
	@PostMapping(path="api/booksRepository") public void create(@RequestBody BookEntity book) {
		booksRepository.save(book);
	}
	@GetMapping(path="api/booksRepository/{isbn}") public BookEntity read(@PathVariable("isbn") String isbn) {
		Optional<BookEntity> result = booksRepository.findById(isbn);
		if (result.isPresent()) {
			return result.get();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping(path="api/booksRepository") public void update(@RequestBody BookEntity book) {
		booksRepository.save(book);
	}
	@DeleteMapping(path="api/booksRepository/{isbn}") public void delete(@PathVariable("isbn") String isbn) {
		booksRepository.deleteById(isbn);
	}
	
}
