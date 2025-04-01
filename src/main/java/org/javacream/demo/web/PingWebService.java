package org.javacream.demo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingWebService {

    @GetMapping(path = "/api/ping", produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping(){
        return "pong";
    }
   @GetMapping(path = "/api/echo/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echo(@RequestPPathVariable("name") String name){
    return "Hello, " + name;
    }
}
