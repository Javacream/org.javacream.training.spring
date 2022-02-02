package org.javacream.books.warehouse.impl;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.log.api.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = {BookException.class})
public class EntityBooksService implements BooksService {

    @PersistenceContext private EntityManager entityManager;
    @Autowired
    private StoreService storeService;


    @Autowired @IsbnGeneratorService.SequenceStrategy
    private IsbnGeneratorService isbnGeneratorService;

   @Override
    public void newBook(Book newBook) throws BookException {
        if (newBook == null){
            throw new BookException(BookException.BookExceptionType.NOT_CREATED, "cannot create null book");

        }
        String isbn = newBook.getIsbn();
        entityManager.persist(newBook);
    }
    @Override
    public Book findBookByIsbn(String isbn) throws BookException{
        if (isbn == null){
            throw new BookException(BookException.BookExceptionType.NOT_FOUND, "cannot search using null isbn");

        }
        Book result = entityManager.find(Book.class, isbn);
        if (result == null){
            throw new BookException(BookException.BookExceptionType.NOT_FOUND, "isbn " + isbn + " not found");
        }
        setAvailability(result);
        return result;
    }

    @Override
    public List<Book> findAll(){
        List<Book> result =  entityManager.createQuery("select b from Book as b", Book.class).getResultList();
        setAvailability(result);
        return result;

    }
    @Override
    public void update(Book book) throws BookException{
        if (book == null){
            throw new BookException(BookException.BookExceptionType.NOT_UPDATED, "cannot update null book");

        }
        entityManager.merge(book);
    }
    @Override
    public void deleteBookByIsbn(String isbn) throws BookException{
        if (isbn == null){
            throw new BookException(BookException.BookExceptionType.NOT_DELETED, "cannot delete using null isbn");

        }
        try {
            entityManager.remove(entityManager.getReference(Book.class, isbn));
        }
        catch(RuntimeException e){
            throw new BookException(BookException.BookExceptionType.NOT_DELETED, e.getMessage());
        }

    }

    @Override
    public List<Book> findByTitle(String title) throws BookException{
        if (title == null){
            throw new BookException(BookException.BookExceptionType.NOT_FOUND, "cannot search by null title");
        }
        TypedQuery<Book> query = entityManager.createQuery("select b from Book as b where b.title = :title", Book.class);
        query.setParameter("title", title);
        List<Book> result =  query.getResultList();
        setAvailability(result);
        return result;
    }
    @Override
    public String newBook(String title, Double price, Integer pages){
        if (pages == null){
            pages = 0;
        }
        if (price == null){
            price = 0d;
        }

        String isbn = isbnGeneratorService.next();
        Book book = new Book(isbn, title, pages, price, false);
        entityManager.persist(book);
        logService.log("created book, isbn=" + isbn);
        //throw new RuntimeException("******************** TEST-ONLY");
        return isbn;

    }

    @Autowired private LogService logService;
    @Override
    public List<String> findAllIsbns(){
        Query query = entityManager.createQuery("select b.isbn from Book as b");
        List<String> result =  query.getResultList();
        return result;

    }

    @Override
    public List<Book> findByTag(String tag){
        TypedQuery<Book> query = entityManager.createQuery("select b from Book as b where b.tags = :tag", Book.class);
        query.setParameter("tag", tag);
        List<Book> result =  query.getResultList();
        setAvailability(result);
        return result;
    }
    @Override
    public List<Book> findByMaxPrice(Double maxPrice){
        TypedQuery<Book> query = entityManager.createQuery("select b from Book as b where b.price < :maxPrice", Book.class);
        query.setParameter("maxPrice", maxPrice);
        List<Book> result =  query.getResultList();
        setAvailability(result);
        return result;
    }
    @Override
    public List<Book> findByMinPrice(Double minPrice){
        TypedQuery<Book> query = entityManager.createQuery("select b from Book as b where b.price > :minPrice", Book.class);
        query.setParameter("minPrice", minPrice);
        List<Book> result =  query.getResultList();
        setAvailability(result);
        return result;
    }
    @Override
    public List<Book> findByPriceRange(Double minPrice, Double maxPrice){
        TypedQuery<Book> query = entityManager.createQuery("select b from Book as b where b.price < :maxPrice and b.price > :minPrice", Book.class);
        query.setParameter("maxPrice", maxPrice);
        query.setParameter("minPrice", minPrice);
        List<Book> result =  query.getResultList();
        setAvailability(result);
        return result;
    }

    @Override
    public List<Book> findAvailable(){
        List<Book> result = findAll().stream().filter(book -> (isAvailable(book.getIsbn()))).collect(Collectors.toList());
        setAvailability(result);
        return result;
    }

    private void setAvailability(Collection<Book> books){
        books.forEach(this::setAvailability);
    }
    private void setAvailability(Book book){
            book.setAvailable(isAvailable(book.getIsbn()));

    }

    private Boolean isAvailable(String isbn){
        return storeService.getStock("books", isbn) > 0;
    }
}
