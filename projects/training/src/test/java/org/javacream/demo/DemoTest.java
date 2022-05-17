package org.javacream.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class DemoTest {
	
	@Test public void plain(){
		new Demo();
	}

}
