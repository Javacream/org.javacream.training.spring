package org.javacream;

import javax.annotation.PostConstruct;

import org.javacream.audit.api.AuditService;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ImportResource({"classpath:booksService.xml"})
public class BooksWarehouseApplication {

	@Autowired private BooksService booksService;
	@Autowired private AuditService auditService;
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BooksWarehouseApplication.class);
		springApplication.setAdditionalProfiles("prod");
		springApplication.run(args);
	}
	
	@PostConstruct public void init() {
		try {
			System.out.println(booksService.findAllBooks());
			System.out.println(booksService.newBook("Spring Boot"));
			System.out.println(booksService.findAllBooks());
		} catch (BookException e) {
			e.printStackTrace();
		}
		auditService.writeAudit("From Application");
	}
	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.basicAuthorization("javacream", "javacream").build();

}
}