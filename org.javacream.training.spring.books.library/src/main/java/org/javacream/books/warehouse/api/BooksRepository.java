package org.javacream.books.warehouse.api;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, String> {
}
