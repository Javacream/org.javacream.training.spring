package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/application_xml.xml")
//@ContextConfiguration(classes= {MapBooksService.class, RandomIsbnGenerator.class, SimpleStoreService.class})
//@ContextConfiguration
public class BooksServiceSpringTest {

	@Autowired
	private BooksService booksService;
	@Autowired
	private IsbnGenerator isbnGenerator;
	
	@Test public void doSpringTest() {
		TestActor.doTest(booksService);
		System.out.println(isbnGenerator.next());
	}
	
//	@Configuration
//	@ComponentScan(basePackages="org.javacream")
//	public static class TestConfig{
//		@Bean @Qualifier("testIsbnGenerator")
//		public RandomIsbnGenerator randomIsbnGenerator() {
//			RandomIsbnGenerator rg = new RandomIsbnGenerator();
//			rg.setCountryCode("-is");
//			rg.setPrefix("From Configuration Class");
//			return rg;
//		}
//	}
	
	
	@Test public void untypicalSpringTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application_xml.xml");
		BooksService bs = context.getBean(BooksService.class);
		TestActor.doTest(bs);
	}
}
