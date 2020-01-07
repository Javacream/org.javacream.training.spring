package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class IsbnGeneratorTest {

	@Autowired
	@RandomStrategy
	//@Qualifier("sequence")
	//@Resource(name = "randomIsbnGenerator")
	private IsbnGenerator isbnGenerator;
	@Test
	public void testBusinessObjects() {
		System.out.println(isbnGenerator.next());

	}

	

}
