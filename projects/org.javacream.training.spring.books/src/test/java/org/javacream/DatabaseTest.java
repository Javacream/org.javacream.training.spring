package org.javacream;

import org.javacream.demo.database.DatabaseDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test") 
public class DatabaseTest {

	@Autowired DatabaseDemo demo;
	@Test public void contextLoads() {
		
	}
	@Test public void testDemo() {	
		demo.demo();
	}
	
}
