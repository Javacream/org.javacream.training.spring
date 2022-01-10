package org.javacream.training.books.warehouse;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class BooksService {
    private Map<String, Book> books = new HashMap<>();
    private Properties store;

    public BooksService() {
        store = new Properties();
        try {
            store.load(this.getClass().getResourceAsStream("/store.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

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
        setAvailability(result);
        return result;
    }

    public List<Book> findAll(){
        List<Book> result =  new ArrayList<>(books.values());
        setAvailability(result);
        return result;

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

    public List<Book> findByTitle(String title) throws BookException{
        if (title == null){
            throw new BookException(BookException.BookExceptionType.NOT_FOUND, "cannot search by null title");
        }
        List<Book> result =  books.values().stream().filter(book -> book.getTitle().equals(title)).collect(Collectors.toList());
        setAvailability(result);
        return result;
    }
    private Random random = new Random();
    public String newBook(String title, Double price, Integer pages){
        if (pages == null){
            pages = 0;
        }
        if (price == null){
            price = 0d;
        }

        String isbn = "Isbn:" + random.nextInt();
        Book book = new Book(isbn, title, pages, price, false);
        books.put(isbn, book);
        return isbn;

    }
    public List<String> findAllIsbns(){
        return books.values().stream().map(book -> book.getIsbn()).collect(Collectors.toList());
    }

    public List<Book> findByTag(String tag){
        List<Book> result =  books.values().stream().filter(book -> book.getTags().contains(tag)).collect(Collectors.toList());
        setAvailability(result);
        return result;
    }
    public List<Book> findByMaxPrice(Double maxPrice){
        List<Book> result =  books.values().stream().filter(book -> book.getPrice() <= maxPrice).collect(Collectors.toList());
        setAvailability(result);
        return result;
    }
    public List<Book> findByMinPrice(Double minPrice){
        List<Book> result =  books.values().stream().filter(book -> book.getPrice() >= minPrice).collect(Collectors.toList());
        setAvailability(result);
        return result;
    }
    public List<Book> findByPriceRange(Double minPrice, Double maxPrice){
        List<Book> result =  books.values().stream().filter(book -> (book.getPrice() >= minPrice)&&(book.getPrice() <= maxPrice)).collect(Collectors.toList());
        setAvailability(result);
        return result;
    }

    public List<Book> findAvailable(){
        List<Book> result = books.values().stream().filter(book -> (isAvailable(book.getIsbn()))).collect(Collectors.toList());
        setAvailability(result);
        return result;
    }

    private void setAvailability(Collection<Book> books){
        books.stream().forEach(book -> setAvailability(book));
    }
    private void setAvailability(Book book){
            book.setAvailable(isAvailable(book.getIsbn()));

    }

    private Boolean isAvailable(String isbn){
        try {
            String stockString = store.get(isbn).toString();
            Integer stock = Integer.parseInt(stockString);
            return stock > 0;
        }
        catch(NullPointerException npe){
                return false;
        }
    }
}
