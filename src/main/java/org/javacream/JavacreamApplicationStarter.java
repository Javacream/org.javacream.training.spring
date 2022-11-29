package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavacreamApplicationStarter {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(JavacreamApplicationStarter.class);
		application.setAdditionalProfiles("prod");
		application.run(args);
	}

}
