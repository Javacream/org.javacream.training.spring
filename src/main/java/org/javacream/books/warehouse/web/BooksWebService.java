package org.javacream.books.warehouse.web;

import java.util.Collection;
import java.util.stream.Collectors;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BooksWebService {

    @Autowired
    private BooksService booksService;

    @PostMapping(path = "api/book/{title}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String newBook(@PathVariable("title") String title) {
        try {
            return booksService.newBook(title);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping(path = "api/book/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBookByIsbn(@PathVariable("isbn") String isbn) {
        try {
            return booksService.findBookByIsbn(isbn);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "api/books/price")
    public void updatePrice(@RequestHeader("isbn") String isbn, @RequestHeader("price") double price) {
        try {
            Book b = findBookByIsbn(isbn);
            b.setPrice(price);
            booksService.updateBook(b);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @PutMapping(path = "api/books/title")
    public void updateTitle(@RequestHeader("isbn") String isbn, @RequestHeader("title") String title) {
        try {
            Book b = findBookByIsbn(isbn);
            b.setTitle(title);
            booksService.updateBook(b);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping(path = "api/book/{isbn}")
    public void deleteBookByIsbn(@PathVariable("isbn") String isbn){
        try {
            booksService.deleteBookByIsbn(isbn);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping(path = "api/book")
    public Collection<String> findAllBooks() {
        return booksService.findAllBooks().stream().map(b -> b.getIsbn()).collect(Collectors.toList());
    }
}