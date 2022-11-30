package org.javacream.demo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoWebService {
	
	@GetMapping(path = "api/demo/ping", produces = MediaType.TEXT_PLAIN_VALUE)
	public String ping() {
		return "pong";
	}

	@GetMapping(path = "api/demo/echo/{m}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String echoWithPath(@PathVariable("m") String message) {
		return "echoWithPath" + message;
	}
	@GetMapping(path = "api/demo/echo-query", produces = MediaType.TEXT_PLAIN_VALUE)
	public String echoWithQueryParam(@RequestParam("m") String message) {
		return "echoWithQueryParam" + message;
	}
	@GetMapping(path = "api/demo/echo-header", produces = MediaType.TEXT_PLAIN_VALUE)
	public String echoWithHeaderParam(@RequestHeader("m") String message) {
		return "echoWithHeader" + message;
	}

}
