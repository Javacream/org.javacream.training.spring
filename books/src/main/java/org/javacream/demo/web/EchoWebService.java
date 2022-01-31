package org.javacream.demo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoWebService {
    /*
    url= http://localhost:8080/demo/ping
    Http-Methode: GET
    MediaType: text/plain
     */
    @GetMapping(path = "demo/ping", produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping(){
        return "pong";
    }

    /*
    url= http://localhost:8080/demo/echo/MESSAGE
    Http-Methode: GET
    MediaType: text/plain
     */
    @GetMapping(path = "demo/echo/{m}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echo(@PathVariable("m") String message){
        System.out.println("received " + message);
        return message;
    }


}
