package org.javacream.demo;

import javax.annotation.PostConstruct;

import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InjectionDemo {

	@Autowired private BooksService booksService;

	@PostConstruct public void init() {
		System.out.println("+++++++++++++++++++++++ booksService=" + booksService + " using " + this);
	}
	public void check() {
		System.out.println("BooksService=" + booksService + " using " + this);
	}
}
