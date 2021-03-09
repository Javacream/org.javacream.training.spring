package org.javacream.books.repository.test;

import java.util.Optional;

import org.javacream.books.repository.api.BookEntity;
import org.javacream.books.repository.api.BooksRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BooksRepositoryTest {

	@Autowired
	private BooksRepository booksRepository;

	@Test
	public void contextLoads() {

	}

	@Test
	public void findByIsbn1FindsBookWithTitleTitle1() {
		System.out.println(booksRepository.findAll());
		Optional<BookEntity> result = booksRepository.findById("ISBN1");
		BookEntity book = result.get();
		Assertions.assertEquals("Title1", book.getTitle());
	}
}
