package org.javacream;

import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:spring-beans.xml")
public class JavacreamApplication {

    @Bean @Qualifier("prefix")
    public String prefix(@Value("${isbngenerator.prefix}") String p){
        System.out.println("##################### GENERATING PREFIX " + p);
        return p;
    }

    @Bean @Qualifier("countryCode") public String countryCode(@Value("${isbngenerator.countryCode}") String cc){
        return cc;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(JavacreamApplication.class);
        app.setAdditionalProfiles("prod");//-> in der Praxis häufig eine Aufrufschalter
        app.run(args);
    }

}
