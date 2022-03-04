package org.javacream.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class InjectionDemoTest {
	@Autowired InjectionDemo demo;
	@Test public void doDemo() {
		//InjectionDemo demo = new InjectionDemo();
		demo.check();
	}
}
