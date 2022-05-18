package org.javacream.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestService {

	@GetMapping(path="demo/ping")
	public String ping() {
		return "pong";
	}
}
