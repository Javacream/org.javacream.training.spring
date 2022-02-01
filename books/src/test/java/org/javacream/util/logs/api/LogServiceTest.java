package org.javacream.util.logs.api;

import org.javacream.util.log.api.LogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class LogServiceTest {
    @Autowired private LogService logService;
    @Test public void loggingMessageIsPossible(){
        logService.log("TEST");
    }
}
