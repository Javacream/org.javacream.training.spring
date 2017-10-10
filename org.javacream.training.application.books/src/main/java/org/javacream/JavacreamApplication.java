package org.javacream;

import javax.annotation.PostConstruct;

import org.javacream.training.SimpleBusiness2;
import org.javacream.training.SimpleBusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

//@Configuration
//@ComponentScan("org.javacream")
@SpringBootApplication
@Scope("singleton")
//@ImportResource("classpath:/javacream-application.xml")
public class JavacreamApplication {

//	@Autowired SimpleBusinessDelegate sbd;
//	@Autowired SimpleBusiness2 sb2;
	public static void main(String[] args) {
		SpringApplication.run(JavacreamApplication.class, args);
	}

//	{
//		
//		System.out.println("Initializing " + this);
//	}
	
//	@PostConstruct public void init() {
//		System.out.println("Init " + this);
//		
//	}
//	
//	@Bean @Scope("singleton") public SimpleBusiness2 createSimpleBusiness2() {
//		//SimpleBusiness2 sb2 = new SimpleBusiness2();
//		sb2.initTheSimpleBusiness2();
//		return sb2;
//	}
}
