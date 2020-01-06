package org.javacream.books.warehouse.test;

import javax.annotation.Resource;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class IsbnGeneratorTest {

	@Autowired
	@Qualifier("sequence")
	//@Resource(name = "randomIsbnGenerator")
	private IsbnGenerator isbnGenerator;
	@Test
	public void testBusinessObjects() {
		System.out.println(isbnGenerator.next());

	}

	

}
