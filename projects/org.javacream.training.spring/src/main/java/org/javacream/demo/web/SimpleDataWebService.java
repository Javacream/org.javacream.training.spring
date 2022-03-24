package org.javacream.demo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleDataWebService {

	@PostMapping(path = "api/simple", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody SimpleData data) {
		System.out.println("creating data " + data);
	}
	
	@GetMapping(path = "api/simple", produces = MediaType.APPLICATION_JSON_VALUE)
	public SimpleData find() {
		System.out.println("searching data...");
		return new SimpleData("demo");
	}

	@PutMapping(path = "api/simple", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SimpleData update(@RequestBody SimpleData data) {
		System.out.println("updating data " + data);
		return new SimpleData("demo");
	}

	@DeleteMapping(path = "api/simple")
	public void delete() {
		System.out.println("deleting data...");
	}

}
