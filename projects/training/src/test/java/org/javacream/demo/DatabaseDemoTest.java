package org.javacream.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class DatabaseDemoTest {

	@Autowired DatabaseDemo demo;
	@Test public void doTest() {
		demo.insertMessage("FROM TEST");
		System.out.println(demo.readMessages());
	}
}
