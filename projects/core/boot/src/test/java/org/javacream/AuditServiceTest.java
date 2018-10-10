package org.javacream;

import org.javacream.audit.api.AuditService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditServiceTest {

	@Autowired private AuditService auditService;
	
	@Test public void testAudit() {
		auditService.writeAudit("HUGO");
	}
}
