package org.javacream.store;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.TestStoreServicePlain;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class StoreConfiguration {

	@Bean @Profile({"test", "java_config"}) StoreService storeService(DataSource dataSource, EntityManager entityManager) {
		return new TestStoreServicePlain(dataSource, entityManager);
	}
}
