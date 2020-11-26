package org.javacream.books.warehouse.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, String> {
	
	List<Book> findByTitle(String title);

}