package org.javacream.books.warehouse.api;

import java.util.List;

public interface BooksService {
    void newBook(Book newBook) throws BookException;

    Book findBookByIsbn(String isbn) throws BookException;

    List<Book> findAll();

    void update(Book book) throws BookException;

    void deleteBookByIsbn(String isbn) throws BookException;

    List<Book> findByTitle(String title) throws BookException;

    String newBook(String title, Double price, Integer pages);

    List<String> findAllIsbns();

    List<Book> findByTag(String tag);

    List<Book> findByMaxPrice(Double maxPrice);

    List<Book> findByMinPrice(Double minPrice);

    List<Book> findByPriceRange(Double minPrice, Double maxPrice);

    List<Book> findAvailable();
}
