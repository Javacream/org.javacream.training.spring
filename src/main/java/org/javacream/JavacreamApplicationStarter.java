package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring-beans.xml")
public class JavacreamApplicationStarter {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(JavacreamApplicationStarter.class);
		application.setAdditionalProfiles("prod");
		application.run(args);
	}

}
