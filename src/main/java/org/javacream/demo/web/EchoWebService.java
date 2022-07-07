package org.javacream.demo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class EchoWebService {

    @GetMapping(path = "ping", produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping() {
        return "pong";
    }

    @GetMapping(path = "echo/path/{m}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echo(@PathVariable("m") String message) {
        return "Echoing using path message: " + message;
    }

    @GetMapping(path = "echo/header", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echoWithHeaderParam(@RequestHeader("m") String message) {
        return "Echoing using header message: " + message;
    }
    @GetMapping(path = "echo/query", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echoWithQueryParam(@RequestParam("m") String message) {
        return "Echoing using query message: " + message;
    }

}
