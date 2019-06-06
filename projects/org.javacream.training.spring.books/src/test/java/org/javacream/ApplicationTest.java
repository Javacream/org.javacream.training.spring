package org.javacream;

import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.test.TestActor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test") 
public class ApplicationTest {

	@Autowired BooksService booksService;
	@Test public void contextLoads() {
		
	}
	@Test public void testBooksSerivce() {
		TestActor.doTest(booksService);
	}
	
}
