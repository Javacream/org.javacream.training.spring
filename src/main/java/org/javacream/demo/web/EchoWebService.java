package org.javacream.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class EchoWebService {
    @Autowired private KafkaTemplate kafkaTemplate;
    @GetMapping(path = "api/demo/ping", produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping(){
        kafkaTemplate.send("topic1", "Hello Spring!");
        return "pong";
    }
    //http://localhost:9090/api/demo/echo/Hugo
    @GetMapping(path = "api/demo/echo/{m}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echoWithPath(@PathVariable("m") String message){
        return message;
    }
    //http://localhost:9090/api/demo/echo, Header wird separat gesetzt
    @GetMapping(path = "api/demo/echo", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echoWithHeader(@RequestHeader("m") String message){
        return message;
    }
    //http://localhost:9090/api/demo/echo/query?m=Hugo
    @GetMapping(path = "api/demo/echo/query", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echoWithQuery(@RequestParam("m") String message){
        return message;
    }

}