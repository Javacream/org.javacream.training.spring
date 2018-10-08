package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UntypicalBooksServiceSpringTest {

	@Test
	public void testBusinessObjects() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/bookswarehouse.xml");
		BooksService booksService = context.getBean("mapBooksService", BooksService.class);
		TestActor.doTest(booksService);
		IsbnGenerator isbnGenerator = context.getBean("randomIsbnGenerator", IsbnGenerator.class);
		IsbnGenerator isbnGenerator2 = context.getBean("randomIsbnGenerator", IsbnGenerator.class);
		
		Assert.assertTrue(isbnGenerator == isbnGenerator2);
		
		//GRÖBSTES HACKING: ((MapBooksService)booksService) NEVER AGAIN!!!!
		Assert.assertTrue(isbnGenerator == ((MapBooksService)booksService).getIsbnGenerator());
		
		context.close();
		
	
	}

	

}
