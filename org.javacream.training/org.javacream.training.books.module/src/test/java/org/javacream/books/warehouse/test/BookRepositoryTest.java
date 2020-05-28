package org.javacream.books.warehouse.test;

import java.util.Optional;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BookRepositoryTest {
	@Autowired private BooksRepository bookRepository;
	
	@Test public void contextLoads() {
	}

	@Test public void testSaveBook() {
		final String isbn = "ISBN-X";
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle("Title");
		book.setPrice(19.99);
		bookRepository.save(book);
		Optional<Book> search = bookRepository.findById(isbn);
		Book result = search.orElse(new Book());
		System.out.println(result);
	}
}
