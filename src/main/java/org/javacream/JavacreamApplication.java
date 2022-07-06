package org.javacream;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

    @Bean int egal(){
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        return 42;
    }
    @Bean @Qualifier("countryCode") public String countryCode(@Value("${isbngenerator.countryCode}") String cc){
        //Wie oft kommt die Konsolenausgabe -> NUR EINMAL, -> behandelt u.a. Spring Advanced
        egal();
        egal();
        egal();
        return cc;
    }
}
