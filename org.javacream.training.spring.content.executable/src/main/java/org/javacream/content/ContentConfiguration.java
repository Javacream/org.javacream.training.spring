package org.javacream.content;

import java.util.List;

import javax.annotation.PostConstruct;

import org.javacream.content.api.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.core.CouchbaseOperations;

import com.couchbase.client.java.query.N1qlQuery;


@SpringBootApplication
public class ContentConfiguration {

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
		
	}
	

