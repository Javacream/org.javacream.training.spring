package org.javacream.books.warehouse.api;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class FindByPriceRange {
    private BooksService booksService;

    @BeforeEach
    public void init() throws BookException {
        MapBooksService mapBooksService = new MapBooksService();
        RandomIsbnGeneratorService isbnGeneratorService = new RandomIsbnGeneratorService();
        SimpleStoreService storeService = new SimpleStoreService();
        HashMap<String, Book> books = new HashMap<>();
        isbnGeneratorService.setPrefix("Isbn:");
        isbnGeneratorService.setCountryCode("-is");
        mapBooksService.setBooks(books);
        mapBooksService.setStoreService(storeService);
        mapBooksService.setIsbnGeneratorService(isbnGeneratorService);
        booksService = mapBooksService;

        Book book1 = new Book("ISBN1", "Title1", 200, 19.99, true);
        Book book2 = new Book("ISBN2", "Title1", 200, 9.99, true);
        Book book3 = new Book("ISBN3", "Title1", 200, 29.99, true);
        books.put(book1.getIsbn(), book1);
        books.put(book2.getIsbn(), book2);
        books.put(book3.getIsbn(), book3);
    }

    @Test
    public void testFindByPriceRange10to20Finds1Book() throws BookException {
        Assertions.assertEquals(1, booksService.findByPriceRange(10d, 20d).size());
    }
    @Test
    public void testFindByPriceRange5to30Finds3Books() throws BookException {
        Assertions.assertEquals(3, booksService.findByPriceRange(5d, 30d).size());
    }
}
