package org.javacream.books.warehouse.api;

import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class FindBookByTitleTest {
    private BooksService booksService;
    private Book book;

    @BeforeEach public void init() throws BookException{
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

        book = new Book("ISBN1", "Title1", 200, 19.99, true);
        booksService.newBook(book);
    }

    @Test public void testFindBookByTitleTitle1Ok() throws BookException {
        Assertions.assertEquals(1, booksService.findByTitle("Title1").size());
    }
    @Test public void testFindBookByTitleXyzFindsEmptyList() throws BookException {
        Assertions.assertEquals(0, booksService.findByTitle("Xyz").size());
    }
    @Test public void testFindBookByTitleNullThrowsBookException() throws BookException {
        Assertions.assertThrows(BookException.class, () -> booksService.findByTitle(null));
    }
}
