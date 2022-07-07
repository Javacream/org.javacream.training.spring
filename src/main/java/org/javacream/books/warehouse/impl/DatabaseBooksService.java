package org.javacream.books.warehouse.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;


@Repository
@Transactional(rollbackFor = BookException.class)
public class DatabaseBooksService implements BooksService {

    @Autowired
    @IsbnGenerator.SequenceStrategy
    private IsbnGenerator isbnGenerator;
    @Autowired
    private StoreService storeService;

    @PersistenceContext private EntityManager entityManager;

    public String newBook(String title) throws BookException {
        String isbn = isbnGenerator.next();
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        entityManager.persist(book);
        return isbn;
    }

    public Book findBookByIsbn(String isbn) throws BookException {
        try {
            Book result = entityManager.find(Book.class, isbn);
            result.setAvailable(storeService.getStock("books", isbn) > 0);
            return result;
        }
        catch(RuntimeException e) {
            throw new BookException(BookException.BookExceptionType.NOT_FOUND,
                    isbn);
        }
    }

    public Book updateBook(Book bookValue) throws BookException {
        return entityManager.merge(bookValue);
    }

    public void deleteBookByIsbn(String isbn) throws BookException {
        try {
            Book toDeleteProxy = entityManager.getReference(Book.class, isbn);
            entityManager.remove(toDeleteProxy);
        }
        catch(RuntimeException e) {
            throw new BookException(
                    BookException.BookExceptionType.NOT_DELETED, isbn);
            }
    }


    public Collection<Book> findAllBooks() {
        return entityManager.createQuery("select b from Book as b", Book.class).getResultList();
    }

}
