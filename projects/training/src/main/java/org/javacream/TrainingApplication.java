package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication  //@Configuration @ComponentScan("org.javacream") @PropertySource("classpath:application.properties")
@ImportResource("classpath:beans.xml")
public class TrainingApplication {
	

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TrainingApplication.class);
		app.setAdditionalProfiles("prod");
		app.run(args);
	}
}
