package org.javacream.web.rest.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EchoController {

	@GetMapping(path = "ping", produces = "text/plain")
	public String ping() {
		System.out.println("received ping");
		return "pong";
	}


}
