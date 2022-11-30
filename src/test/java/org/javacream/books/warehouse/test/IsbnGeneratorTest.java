package org.javacream.books.warehouse.test;

import org.assertj.core.api.Assertions;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes=IsbnGeneratorTest.IsbnGeneratorTestConfiguration.class)
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
	public void testGebneratenIsbnsAreUnique() {
		String isbn1 = isbnGenerator.next();
		String isbn2 = isbnGenerator.next();
		Assertions.assertThat(isbn1).isNotEqualTo(isbn2);
	}
	@Configuration
	@ComponentScan(basePackages = {"org.javacream.books.isbngenerator", "org.javacream.util.idgenerator"})
	public static class IsbnGeneratorTestConfiguration{
		
	}
}
