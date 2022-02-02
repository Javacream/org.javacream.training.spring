package org.javacream.books.warehouse.repository;

import org.javacream.books.warehouse.api.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, String> {
    List<Book> findByTitle(String title);
    List<Book> findByTitleAndPrice(String title, Double price);
    //List<Book> findByTitleOrderByPages(String title, Double price);

    @Query("select b from Book as b where title like :s")
    Book hugo(String s);

    @Query("select b from Book as b where title like :title")
    List<Book> byTitle(String title);

}
