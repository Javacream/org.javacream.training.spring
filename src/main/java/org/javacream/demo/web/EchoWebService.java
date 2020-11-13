package org.javacream.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoWebService {

	@GetMapping(path = "ping")
	public String ping() {
		return "pong";
	}

	@GetMapping(path = "echo/{message}")

	public String echo(@PathVariable("message") String message) {
		return "Hello " + message;

	}
}
