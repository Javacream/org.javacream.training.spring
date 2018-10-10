package org.javacream;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksRepositoryTest {

	@Autowired BooksRepository booksRepository;
	
	@Test public void testBooksRepo() {
		Book book = new Book();
		book.setIsbn("E GA L");
		book.setTitle("a");
		book.setPrice(19.99);
		booksRepository.save(book);
	}
}
