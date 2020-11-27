package org.javacream.books.warehouse.web;

import java.util.List;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksWebRepository {
	
	@Autowired private BooksRepository booksRepository;
	
	@GetMapping(path = "api/books/repo/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> findBookByTitle(@PathVariable ("title") String title){
			return booksRepository.findByTitle(title);
	}

}
