package org.javacream.content;

import java.util.List;

import javax.annotation.PostConstruct;

import org.javacream.content.api.Content;
import org.javacream.content.api.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.core.CouchbaseOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.couchbase.client.java.query.N1qlQuery;

@SpringBootApplication
@RestController
public class ContentWebServiceApplication {

		@Autowired ContentService contentService;
		@Autowired
		private CouchbaseOperations couchbaseOperations;

		@PostConstruct
		private void postConstruct() {

			// add _class attribute
			List<Content> contentWithoutClassAttribute = couchbaseOperations.findByN1QL(N1qlQuery.simple( //
					"SELECT META(`content`).id AS _ID, META(`content`).cas AS _CAS, `content`.* " + //
							"FROM `content` " + //
							"WHERE _class IS MISSING;"),
					Content.class);

			contentWithoutClassAttribute.forEach(couchbaseOperations::save);
		}
		
		public static void main(String[] args) {
			SpringApplication.run(ContentWebServiceApplication.class, args);
		}
		
		@GetMapping (path = "api/content/{id}", produces = MediaType.APPLICATION_JSON_VALUE) public Content findById(@PathVariable("id") String id) {
			return contentService.findById(id); 
		}
	}
	

