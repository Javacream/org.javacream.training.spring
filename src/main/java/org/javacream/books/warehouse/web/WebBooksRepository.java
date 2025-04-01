package org.javacream.books.warehouse.web;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class WebBooksRepository {
    @Autowired
    BooksRepository booksRepository;

    @GetMapping(path = "api/booksrepo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> findByIsbn() {
        return booksRepository.findAll();
    }
}
