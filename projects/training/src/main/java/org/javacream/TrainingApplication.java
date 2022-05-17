package org.javacream;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication  //@Configuration @ContextConfiguration("org.javacream")
@ImportResource("classpath:beans.xml")
public class TrainingApplication {
	

}
