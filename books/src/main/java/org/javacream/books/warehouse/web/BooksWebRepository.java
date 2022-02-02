package org.javacream.books.warehouse.web;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class BooksWebRepository {
    @Autowired
    private BooksRepository booksRepository;

    @PostMapping(path = "api/booksrepository", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void newBook(@RequestBody Book book) {
        booksRepository.save(book);
    }

    @GetMapping(path = "api/booksrepository/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBookByIsbn(@PathVariable("isbn") String isbn) {
        Optional<Book> result = booksRepository.findById(isbn);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "api/booksrepository", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBook(@RequestBody Book book) {
        booksRepository.save(book);
    }

    @DeleteMapping(path = "api/booksrepository/{isbn}")
    public void deleteBookByIsbn(@PathVariable("isbn") String isbn) {
        try {
            booksRepository.deleteById(isbn);
        }
        catch(RuntimeException re){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}