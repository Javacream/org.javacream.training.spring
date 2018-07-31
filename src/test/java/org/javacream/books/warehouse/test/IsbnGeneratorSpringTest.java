package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ActiveProfiles("prod")
public class IsbnGeneratorSpringTest {

	@Autowired @Qualifier("randomAlgorithm")
	private IsbnGenerator isbnGenerator;
	@Autowired
    Environment environment;
 
	@Test
	public void doSpringTest() {
        for (final String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }   
		System.out.println(isbnGenerator.next());
		System.out.println(isbnGenerator.next());
		System.out.println(isbnGenerator.next());
		System.out.println(isbnGenerator.next());
		
	}

	@Configuration
	@ComponentScan(basePackages = "org.javacream")
	public static class TestConfig {
	}
}
