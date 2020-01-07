package org.javacream.web.rest.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@DeleteMapping(path = "fritz/{type}")
	public void emil(@RequestHeader("del") String toDelete, @RequestParam("sync") boolean sync,
			@PathVariable("type") String type) {
		System.out.println("Received request to delete " + toDelete + ", mode=" + sync + ", type=" + type);
	}

}
