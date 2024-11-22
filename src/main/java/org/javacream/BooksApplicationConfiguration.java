package org.javacream;

import org.apache.kafka.clients.admin.NewTopic;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.decorators.AuditingStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class BooksApplicationConfiguration {

    @Bean @IsbnGenerator.SequenceStrategy public IsbnGenerator countersbnGenerator(){
        return new CounterIsbnGenerator();
    }

    @Bean @Primary public StoreService storeService(StoreService storeService){
        AuditingStoreService auditingStoreService = new AuditingStoreService();
        auditingStoreService.setStoreService(storeService);
        return auditingStoreService;
    }

    @Bean
    NewTopic javacream(){
        return TopicBuilder.name("javacream").partitions(10).replicas(2).build();
    }
}
