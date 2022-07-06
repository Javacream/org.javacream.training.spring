package org.javacream;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring-beans.xml")
public class JavacreamApplication {

    @Bean @Qualifier("prefix")
    public String prefix(){
        return "ConfigIsbn:";
    }
    @Bean @Qualifier("countryCode") public String countryCode(){
        return "-is";
    }
}
