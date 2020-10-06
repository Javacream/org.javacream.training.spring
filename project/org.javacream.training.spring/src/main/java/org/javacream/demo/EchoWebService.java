package org.javacream.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EchoWebService {

	@GetMapping(path = "echo/ping")
	public String ping() {
		return "pong";
		
	}
	
	@GetMapping(path = "echo/message/{m}")
	public String echo(@PathVariable("m") String message) {
		System.out.println("Echoing message " + message);
		return "Hello " + message;
	}
}
