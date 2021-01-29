package org.javacream.books.warehouse.web;


import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksDataWebService {
    @Autowired private BooksRepository booksRepository;

    @GetMapping(path="api/booksdata", produces="application/json") public List<Book> findAll() {
        return booksRepository.findAll();
    }
    @GetMapping(path="api/booksdata/{isbn}", produces="application/json") public Book findByIsbn(@PathVariable("isbn") String isbn) {
        return booksRepository.findById(isbn).get();
    }
}
