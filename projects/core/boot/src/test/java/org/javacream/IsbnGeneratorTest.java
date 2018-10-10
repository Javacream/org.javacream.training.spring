package org.javacream;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IsbnGeneratorTest {

	@Autowired @Qualifier(IsbnGenerator.SEQUENCE) private IsbnGenerator isbnGenerator;
	
	@Test public void testIsbnGeneration() {
		System.out.println(isbnGenerator.next());
	}
}
