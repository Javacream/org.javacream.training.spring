package org.javacream.books.warehouse.api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, String> {
}
