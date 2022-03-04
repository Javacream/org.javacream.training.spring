package org.javacream.util;

import org.springframework.stereotype.Service;

@Service
public class AuditService {

	public void log(String category, String message) {
		System.out.println("AUDITSERVICE: category " + category + " writes message " + message);
	}
}
