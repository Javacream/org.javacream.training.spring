package org.javacream.content;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SpringBootApplication
@EnableCouchbaseRepositories
public class ContentServiceConfiguration extends AbstractCouchbaseConfiguration{


		@Override
		public String getUserName() {
			return "Administrator";
		}

		@Override
		public String getPassword() {
			return "admin123";
		}

		@Override
		public String getConnectionString() {
			return "h2908727.stratoserver.net";
		}

		@Override
		public String getBucketName() {
			return "content";
		}
	}
