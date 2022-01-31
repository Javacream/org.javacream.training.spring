package org.javacream.demo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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
}
