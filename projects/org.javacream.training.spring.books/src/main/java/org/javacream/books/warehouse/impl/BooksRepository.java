package org.javacream.books.warehouse.impl;

import java.util.List;

import org.javacream.books.warehouse.api.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, String> {
	
	List<Book> findByTitle(String title);

}
