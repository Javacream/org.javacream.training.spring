package org.javacream.books.warehouse.repository;

import org.javacream.books.warehouse.api.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, String>{

}
