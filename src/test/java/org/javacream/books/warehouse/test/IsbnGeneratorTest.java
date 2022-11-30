package org.javacream.books.warehouse.test;

import org.assertj.core.api.Assertions;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes=IsbnGeneratorTest.IsbnGeneratorTestConfiguration.class, webEnvironment = WebEnvironment.NONE)
@ActiveProfiles("test")
public class IsbnGeneratorTest {

	@Autowired private IsbnGenerator isbnGenerator;
	
	@Test
	public void contextLoads() {
		
	}
	@Test
	public void testIsbnGenerator() {
		Assertions.assertThat(isbnGenerator.next()).isNotNull();
	}
	@Test
	public void testGeneratedIsbnsAreUnique() {
		String isbn1 = isbnGenerator.next();
		String isbn2 = isbnGenerator.next();
		Assertions.assertThat(isbn1).isNotEqualTo(isbn2);
	}
	@Configuration
	@ComponentScan(basePackages = {"org.javacream.books.isbngenerator", "org.javacream.util.idgenerator"})
	public static class IsbnGeneratorTestConfiguration{
		
	}
}
