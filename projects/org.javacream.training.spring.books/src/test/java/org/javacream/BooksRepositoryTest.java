package org.javacream;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.impl.BooksRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test") 
public class BooksRepositoryTest {

	@Autowired BooksRepository booksRepository;
	
	@Test public void testCrud() {
		Book book = new Book();
		book.setIsbn("ISBN" + System.currentTimeMillis());
		book.setTitle("Spring Data in Action");
		book.setPrice(39.99);
		booksRepository.save(book);
		
		System.out.println(booksRepository.findByTitle("Spring Data in Action"));
		Book example = new Book();
		example.setPrice(39.99);
		System.out.println(booksRepository.findAll(Example.of(example)));
	}
}
