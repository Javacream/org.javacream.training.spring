package org.javacream.books.warehouse.repository;

import java.util.List;

import org.javacream.books.warehouse.api.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

//@Repository und @Transactional(propagation = REQUIRED) ist Default
public interface BooksRepository extends JpaRepository<Book, String>, BooksRepositoryOperations{

	List<Book> findByTitle(String title);
	
	@Query("select b from Book as b where price > 19.99")
	List<Book> expensiveBooks();
	
	@Query("update Book b set b.title = ?1 where b.isbn = ?2")
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	void update(String title, String isbn);
}
