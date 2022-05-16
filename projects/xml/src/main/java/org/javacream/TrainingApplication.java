package org.javacream;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "org.javacream")
@ImportResource("classpath:beans.xml")
public class TrainingApplication {

}
