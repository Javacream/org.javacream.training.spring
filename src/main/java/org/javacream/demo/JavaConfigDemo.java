package org.javacream.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfigDemo {

    @Bean @Qualifier("friendly")
    public String friendlyMessage(){
        System.out.println("*********** CALLING friendlyMessage");
        return "hello";
    }
    @Bean @Qualifier("formal")
    public String formalMessage(){
        System.out.println("*********** CALLING formalMessage");
        return "good day";
    }

    @Bean public StringBuffer buffer(){
        String content = friendlyMessage();
        content = friendlyMessage();
        content = friendlyMessage();
        return new StringBuffer(content);

    }
}
