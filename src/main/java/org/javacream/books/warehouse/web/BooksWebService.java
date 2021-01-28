package org.javacream.books.warehouse.web;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class BooksWebService {
    @Autowired @Qualifier("forApplication")private BooksService booksService;

    //curl -X POST -verbose http://localhost:9090/api/books/Spring
    @PostMapping(path="api/books/{title}")
    public String newBook(@PathVariable("title") String title) {
        try {
            return booksService.newBook(title);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    //curl -X GET -verbose http://localhost:9090/api/books/ISBN:0-de
    @GetMapping(path="api/books/{isbn}", produces = "application/json")
    public Book findBookByIsbn(@PathVariable("isbn") String isbn){
        try {
            return booksService.findBookByIsbn(isbn);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //curl -X PUT -H "price: 19.99" -verbose http://localhost:9090/api/books/price/ISBN:0-de
    @PutMapping(path="api/books/price/{isbn}")
    public void updatePrice(@PathVariable("isbn") String isbn, @RequestHeader("price") double price){
    try{
        Book book = booksService.findBookByIsbn(isbn);
        book.setPrice(price);
        booksService.updateBook(book);
    } catch (BookException e) {
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
    }
    }
    //curl -X PUT -H "title: Sprong" -verbose http://localhost:9090/api/books/title/ISBN:0-de
    @PutMapping(path="api/books/title/{isbn}")
    public void updateTitle(@PathVariable("isbn") String isbn, @RequestHeader("title") String title){
        try{
            Book book = booksService.findBookByIsbn(isbn);
            book.setTitle(title);
            booksService.updateBook(book);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    //curl -X DELETE -verbose http://localhost:9090/api/books/ISBN:0-de
    @DeleteMapping(path="api/books/{isbn}")
    public void deleteBookByIsbn(@PathVariable("isbn") String isbn){
        try {
            booksService.deleteBookByIsbn(isbn);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    //curl -X GET -verbose http://localhost:9090/api/books
    @GetMapping(path="api/books", produces = "application/json")
    public Collection<String> findAllBooks() {
        return new ArrayList<>(booksService.findAllBooks()).stream().map(book -> book.getIsbn()+ "=" + book.getTitle()).collect(Collectors.toList());
    }
}
