package org.javacream.books.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BookEntity, String>{

}
