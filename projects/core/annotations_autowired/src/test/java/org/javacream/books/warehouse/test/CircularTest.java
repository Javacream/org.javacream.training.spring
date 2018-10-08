package org.javacream.books.warehouse.test;

import org.javacream.demo.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CircularTest {
	
	@Autowired private A x;
	@Test public void testCircular() {
		x.doSomething();
	}
	@Configuration
	@ComponentScan("org.javacream.demo")
	public static class TestConfiguration {

	}

}
