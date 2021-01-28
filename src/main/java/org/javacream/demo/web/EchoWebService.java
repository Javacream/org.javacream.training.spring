package org.javacream.demo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class EchoWebService {

    @GetMapping(path = "ping", produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping(){
        return "pong";
    }

    //http://localhost:8080/echo/Hello
    @GetMapping(path = "echo/{m}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echoWithPathVariable(@PathVariable("m") String message){
        System.out.println("Echoing " + message);
        return new StringBuilder(message).reverse().toString();
    }

    //http://localhost:8080/echo?mess=Hello
    @GetMapping(path = "echo", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echoWithQueryParam(@RequestParam("mess") String message){
        System.out.println("Echoing " + message);
        return new StringBuilder(message).reverse().toString();
    }



    //curl -X GET -H "mess: Hello" http://localhost:8080/echoWithHeader
    @GetMapping(path = "echoWithHeader", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echoWithHeaderParam(@RequestHeader("mess") String message){
        System.out.println("Echoing " + message);
        return new StringBuilder(message).reverse().toString();
    }

}
