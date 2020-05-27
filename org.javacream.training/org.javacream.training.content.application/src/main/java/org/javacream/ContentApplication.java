package org.javacream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ContentApplication {

	@Value("${content.directory}") private String dir;
	
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ContentApplication.class);
		application.run(args);
	}

	@GetMapping(path="content/{id}")
	public String getContent(@PathVariable("id")String id, @RequestParam(name = "delay", defaultValue = "0") long delay) {
		if (delay > 0) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				//OK
			}
		}
		try {
			return new String(Files.readAllBytes(Paths.get("/home/rainer/content/" + id)));
		} catch (IOException e) {
			return "NOT FOUND";
		}
	}
}
