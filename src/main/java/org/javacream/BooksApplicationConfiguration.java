package org.javacream;

import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class BooksApplicationConfiguration {
    @PostConstruct public void init(){
        System.out.println("************** " + this);
    }
    @Autowired  private BooksService booksService;

    @Bean
    public String prefix(){
        System.out.println("***** called prefix()");
        return "Hugo";
    }
    @Bean
    public String countryCode(){
        String prefix = prefix();
        String prefix2 = prefix();

        return "-is" + prefix + prefix2;
    }
}
