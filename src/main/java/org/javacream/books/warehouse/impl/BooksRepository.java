package org.javacream.books.warehouse.impl;

import org.javacream.books.warehouse.api.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, String>{

}
