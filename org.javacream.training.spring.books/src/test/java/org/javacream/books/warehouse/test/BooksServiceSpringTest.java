package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.impl.DatabaseBooksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BooksServiceSpringTest {

	@Autowired
	private DatabaseBooksService mapBooksService;
	@Test
	public void testBusinessObjects() {

		TestActor.doTest(mapBooksService);
		
	
	}

	

}
