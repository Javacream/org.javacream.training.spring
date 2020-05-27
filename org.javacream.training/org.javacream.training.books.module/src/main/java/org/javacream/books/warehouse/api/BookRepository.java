package org.javacream.books.warehouse.api;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile("test")
public interface BookRepository extends JpaRepository<Book, String>{

}
