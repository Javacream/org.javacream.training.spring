package org.javacream.books.warehouse.test;

import org.javacream.books.BooksWarehouseConfiguration;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author Dr. Rainer Sawitzki
 * @company Javacream
 * @mailto training@rainer-sawitzki.de
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(BooksWarehouseConfiguration.class)
@ActiveProfiles({"networktest", "sequence"})
public class BooksServiceSpringBootTest {
	@Autowired BooksService booksService;
	@Test
	public void testBooksService() {
		TestActor.doTest(booksService);
		
	
	}

	

}
