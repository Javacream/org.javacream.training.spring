package org.javacream.training.books.warehouse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BooksTest {
    @Test public void doTestBooks() throws BookException{
        BooksService booksService = new BooksService();
        Book book1 = new Book("ISBN1", "Title1", 100, 19.99, true);
        booksService.newBook(book1);
        Book searchResult = booksService.findBookByIsbn(book1.getIsbn());
        Assertions.assertEquals(book1, searchResult);
        booksService.deleteBookByIsbn(book1.getIsbn());
    }
}
