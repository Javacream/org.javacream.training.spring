package org.javacream.books.warehouse.web;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class BooksWebRepository {
    @GetMapping(path = "api/books/{isbn}")
    public Book findById(@PathVariable("isbn") String isbn) {
        Optional<Book> result = booksRepository.findById(isbn);
        if (result.isPresent()){
            return result.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    BooksRepository booksRepository;


}
