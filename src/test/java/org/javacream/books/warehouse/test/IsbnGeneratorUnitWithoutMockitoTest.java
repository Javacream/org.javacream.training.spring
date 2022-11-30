package org.javacream.books.warehouse.test;

import org.assertj.core.api.Assertions;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.util.idgenerator.api.IdGenerator;
import org.javacream.util.idgenerator.api.IdGenerator.SequenceStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes=IsbnGeneratorUnitWithoutMockitoTest.IsbnGeneratorTestConfiguration.class)
@ActiveProfiles("test")
public class IsbnGeneratorUnitWithoutMockitoTest {

	@MockBean @SequenceStrategy private IdGenerator idGenerator;
	
	
	@Autowired private IsbnGenerator isbnGenerator;
	
	@BeforeEach public void setUp() {
		Mockito.when(idGenerator.nextId()).thenReturn(42l);
	}
	@Test
	public void contextLoads() {
		
	}
	@Test
	public void testIsbnGenerator() {
		Assertions.assertThat(isbnGenerator.next()).isEqualTo("ISBN:42-is");
	}
	@Configuration
	@ComponentScan(basePackages = {"org.javacream.books.isbngenerator"})
	public static class IsbnGeneratorTestConfiguration{
		
	}
}
