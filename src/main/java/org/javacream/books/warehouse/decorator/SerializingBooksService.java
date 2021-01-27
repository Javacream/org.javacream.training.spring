package org.javacream.books.warehouse.decorator;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;

import java.io.Serializable;
import java.util.Collection;

public class SerializingBooksService implements BooksService {
    @Override
    public String newBook(String title) throws BookException {
        return delegate.newBook(title);
    }

    @Override
    public Book findBookByIsbn(String isbn) throws BookException {
        return SerializationUtils.clone(delegate.findBookByIsbn(isbn));
    }

    @Override
    public Book updateBook(Book book) throws BookException {
        return delegate.updateBook(SerializationUtils.clone(book));
    }

    @Override
    public void deleteBookByIsbn(String isbn) throws BookException {
        delegate.deleteBookByIsbn(isbn);
    }

    @Override
    public Collection<Book> findAllBooks() {
        return SerializationUtils.clone((Serializable & Collection<Book>) delegate.findAllBooks());
    }

    public void setDelegate(BooksService delegate) {
        this.delegate = delegate;
    }

    private BooksService delegate;
}
