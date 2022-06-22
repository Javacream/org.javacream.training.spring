package org.javacream.books.warehouse.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "org.javacream")
@PropertySource("classpath:application.properties")
public class TestConfiguration {

}
