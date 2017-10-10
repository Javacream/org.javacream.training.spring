package org.javacream.books.warehouse.jpa;

import org.javacream.books.warehouse.api.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, String> {

}
