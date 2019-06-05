package org.javacream;

import org.javacream.demo.jpa.CatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test") 
public class CatTest {

	@Autowired private CatService catService;
	@Test public void testCatDemo() {
		catService.insertThommy();
		//catService.doCatDemoWithExternalSimulation();
		catService.doCatDemoWithSelfSimulation();
	}
	
}
