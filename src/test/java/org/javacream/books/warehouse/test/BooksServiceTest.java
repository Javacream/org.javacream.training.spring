package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BooksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author Dr. Rainer Sawitzki
 * @company Javacream
 * @mailto training@rainer-sawitzki.de
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BooksServiceTest {
	@Autowired 
	private BooksService booksService;
	
	@Test
	public void testBusinessObjects() {
		TestActor.doTest(booksService);
		
	
	}

	
	@Configuration
	@ComponentScan(basePackages="org.javacream")
	@PropertySource("app.properties")
	public static class BooksWarehouseConfiguration{
		
	}
}
