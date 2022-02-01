package org.javacream.books.warehouse.web;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BooksWebService {
    @GetMapping(path = "api/books/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBookByIsbn(@PathVariable("isbn") String isbn){
        try {
            return booksService.findBookByIsbn(isbn);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "api/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookInfo> findAll() {
        return booksService.findAll().stream().map(b -> new BookInfo(b.getIsbn(), b.getTitle())).collect(Collectors.toList());
    }

    @PutMapping(path = "api/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Book book) {
        try {
            booksService.update(book);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    @PutMapping(path = "api/books/{isbn}/price/{price}")
    public void updatePrice(@PathVariable("isbn") String isbn, @PathVariable("price") Double newPrice) {
        try {
            Book b = booksService.findBookByIsbn(isbn);
            b.setPrice(newPrice);
            booksService.update(b);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping(path = "api/books/{isbn}/page/{page}")
    public void updatePrice(@PathVariable("isbn") String isbn, @PathVariable("page") Integer newPages) {
        try {
            Book b = booksService.findBookByIsbn(isbn);
            b.setPages(newPages);
            booksService.update(b);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "api/books/{isbn}")
    public void deleteBookByIsbn(String isbn){
    try{
        booksService.deleteBookByIsbn(isbn);
    } catch (BookException e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    }

    @GetMapping(path = "api/books/title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> findByTitle(@RequestParam("title") String title){
        try {
            return booksService.findByTitle(title);
        } catch (BookException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="api/books/{title}")
    public String newBook(@PathVariable("title") String title, @RequestParam(value = "price", defaultValue = "0")Double price, @RequestParam(value = "pages", defaultValue = "0")Integer pages) {
        return booksService.newBook(title, price, pages);
    }

    @GetMapping(path = "api/books/isbns", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> findAllIsbns() {
        return booksService.findAllIsbns();
    }

    @GetMapping(path = "api/books/tags/{tag}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> findByTag(@PathVariable("tag") String tag) {
        return booksService.findByTag(tag);
    }

    public List<Book> findByMaxPrice(Double maxPrice) {
        return booksService.findByMaxPrice(maxPrice);
    }

    public List<Book> findByMinPrice(Double minPrice) {
        return booksService.findByMinPrice(minPrice);
    }

    public List<Book> findByPriceRange(Double minPrice, Double maxPrice) {
        return booksService.findByPriceRange(minPrice, maxPrice);
    }

    public List<Book> findAvailable() {
        return booksService.findAvailable();
    }

    @Autowired private BooksService booksService;


}
