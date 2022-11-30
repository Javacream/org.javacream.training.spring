package org.javacream.books.warehouse.test;

import org.assertj.core.api.Assertions;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.util.idgenerator.api.IdGenerator;
import org.javacream.util.idgenerator.api.IdGenerator.SequenceStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes=IsbnGeneratorUnitWithoutMockitoTest.IsbnGeneratorTestConfiguration.class)
@ActiveProfiles("test")
public class IsbnGeneratorUnitWithoutMockitoTest {

	
	@Autowired private IsbnGenerator isbnGenerator;
	
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
		@Bean @SequenceStrategy public IdGenerator idGenerator() {
			return new IdGenerator() {

				@Override
				public long nextId() {
					return 42;
				}
				
			};
		}
	}
}
