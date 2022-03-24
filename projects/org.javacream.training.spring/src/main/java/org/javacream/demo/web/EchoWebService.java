package org.javacream.demo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
public class EchoWebService {

	@GetMapping(path = "api/ping", produces = MediaType.TEXT_PLAIN_VALUE)
	public String ping() {
		return "pong";
	}

	@GetMapping(path = "api/echo/{m}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String echoWithPathVariable(@PathVariable("m") String message) {
		return message;
	}

	@GetMapping(path = "api/echo", produces = MediaType.TEXT_PLAIN_VALUE)
	public String echoWithHttpHeader(@RequestHeader("message") String message) {
		return message;
	}
	@GetMapping(path = "api/echo/query", produces = MediaType.TEXT_PLAIN_VALUE)
	public String echoWithQuery(@RequestParam("message") String message) {
		return message;
	}
	
}
