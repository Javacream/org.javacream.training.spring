package org.javacream.demo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoWebService {

    @GetMapping(path = "ping", produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping(){
        return "pong";
    }

    @GetMapping(path = "echo/{m}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echo(@PathVariable("m") String message){
        return "Echoing message: " + message;
    }

}
