package org.javacream.books.warehouse.web;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class BooksWebService {

    @Autowired
    private BooksService booksService;

    @PostMapping(path = "api/books", produces = MediaType.TEXT_PLAIN_VALUE)
    public String newBook(@RequestParam("title") String title) {
        try {
            return booksService.newBook(title);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping(path = "api/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBookByIsbn(@PathVariable("id") String isbn) {
        try {
            return booksService.findBookByIsbn(isbn);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "api/books/{id}")
    public void updatePrice(@PathVariable("id") String isbn, @RequestParam("newPrice") double newPrice) {
        try {
            Book book = booksService.findBookByIsbn(isbn);
            book.setPrice(newPrice);
            booksService.updateBook(book);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping(path = "api/books/{id}")
    public void deleteBookByIsbn(@PathVariable("id") String isbn) {
        try {
            booksService.deleteBookByIsbn(isbn);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(path = "api/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<String> findAllIsbns() {
        return booksService.findAllBooks().stream().map(book -> book.getIsbn()).collect(Collectors.toList());
    }


}
