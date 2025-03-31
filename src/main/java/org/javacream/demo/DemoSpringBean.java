package org.javacream.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DemoSpringBean {
    @Autowired @Qualifier("formal") String message;
    @Autowired StringBuffer buf;

    @PostConstruct public void init(){
        System.out.println("******************* " + message + ", " + buf);
    }
}
