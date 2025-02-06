package org.javacream.books.warehouse.web;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksRepositoryWebService {
    @Autowired
    BooksRepository booksRepository;

    @GetMapping (path = "api/books")
    public List<Book> findAllBooks(){
        return booksRepository.findAll();
    }
 }
