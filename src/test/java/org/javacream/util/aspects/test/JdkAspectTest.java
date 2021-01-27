package org.javacream.util.aspects.test;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.util.aspects.JdkTracingAspect;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JdkAspectTest {

    @Test public void testStoreServiceWithAspect(){
        StoreService sss = new SimpleStoreService();
        sss = JdkTracingAspect.wrap(sss);
        sss.getStock("irgend", "was");
    }

    @Test public void testListWithAspect(){
        List<String> names = new ArrayList();
        names = JdkTracingAspect.wrap(names);
        names.add("Hugo");
        names.size();
    }
}
