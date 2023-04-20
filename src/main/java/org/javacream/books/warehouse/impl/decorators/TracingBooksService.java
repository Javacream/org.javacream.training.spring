package org.javacream.books.warehouse.impl.decorators;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TracingBooksService implements BooksService{
    public void setDelegate(BooksService delegate) {
        this.delegate = delegate;
    }

    public String newBook(String title) throws BookException {
        System.out.println("calling newBook");
        return delegate.newBook(title);
    }

    public Book findBookByIsbn(String isbn) throws BookException {
        System.out.println("calling findBookByIsbn");
        return delegate.findBookByIsbn(isbn);
    }

    public Book updateBook(Book book) throws BookException {
        System.out.println("calling updateBook");
        return delegate.updateBook(book);
    }

    public void deleteBookByIsbn(String isbn) throws BookException {
        System.out.println("calling deleteBookByIsbn");
        delegate.deleteBookByIsbn(isbn);
    }

    public Collection<Book> findAllBooks() {
        System.out.println("calling findAllBooks");
        return delegate.findAllBooks();
    }

    private BooksService delegate;

}
