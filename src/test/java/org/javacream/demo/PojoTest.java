package org.javacream.demo;

import org.javacream.store.impl.decorators.AuditingStoreService;
import org.junit.jupiter.api.Test;

public class PojoTest {
    @Test public void pojo(){
        new AuditingStoreService();
    }

}

