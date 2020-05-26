package org.javacream.books.warehouse.api;

import org.springframework.data.repository.CrudRepository;

public interface BookCouchbaseRepository extends CrudRepository<Book, String>{

}
