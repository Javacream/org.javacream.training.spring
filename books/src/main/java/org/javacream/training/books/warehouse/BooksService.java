package org.javacream.training.books.warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BooksService {
    private Map<String, Book> books;
    public void newBook(Book newBook) throws BookException{
        if (newBook == null){
            throw new BookException(BookException.BookExceptionType.NOT_CREATED, "cannot create null book");

        }
        String isbn = newBook.getIsbn();
        if (books.containsKey(isbn)){
            throw new BookException(BookException.BookExceptionType.NOT_CREATED, "isbn " + isbn + " exists");

        }
        books.put(newBook.getIsbn(), newBook);
    }
    public Book findBookByIsbn(String isbn) throws BookException{
        if (isbn == null){
            throw new BookException(BookException.BookExceptionType.NOT_FOUND, "cannot search using null isbn");

        }
        Book result = books.get(isbn);
        if (result == null){
            throw new BookException(BookException.BookExceptionType.NOT_FOUND, "isbn " + isbn + " not found");
        }
        return result;
    }

    public List<Book> findAll(){
        return new ArrayList<>(books.values());

    }
    public void update(Book book) throws BookException{
        if (book == null){
            throw new BookException(BookException.BookExceptionType.NOT_UPDATED, "cannot update null book");

        }
        String isbn = book.getIsbn();
        if (!books.containsKey(isbn)){
            throw new BookException(BookException.BookExceptionType.NOT_FOUND, "isbn " + isbn + " not found");
        }
        books.put(book.getIsbn(), book);

    }
    public void deleteBookByIsbn(String isbn) throws BookException{
        if (isbn == null){
            throw new BookException(BookException.BookExceptionType.NOT_DELETED, "cannot delete using null isbn");

        }
        Book deleted = books.remove(isbn);
        if (deleted == null){
            throw new BookException(BookException.BookExceptionType.NOT_FOUND, "isbn " + isbn + " not found");
        }

    }

}
