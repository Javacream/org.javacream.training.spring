package org.javacream.books.warehouse.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BooksRepository extends JpaRepository<Book, String>{

	List<Book> findByTitle(String title);

	List<Book> findByTitleAndPriceOrderByIsbn(String title, double price);
	
	@Query("select b from BookEntity b where b.title = 'hugo'")
	Book hugo();

}
