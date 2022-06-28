package org.javacream.util.aspects;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuditingAspect {
	@PersistenceContext
	private EntityManager entityManager;

	@Before("@annotation(org.javacream.util.aspects.Audit)")
	public void audit(JoinPoint jp) {
		MethodSignature methodSignature = (MethodSignature) jp.getSignature();
		String methodName = methodSignature.getMethod().getName();
		String message = "call " + methodName + " using args " + Arrays.asList(jp.getArgs()) + " at " + System.currentTimeMillis();
		Query query = entityManager.createNativeQuery("insert into messages values (:message)");
		query.setParameter("message", message);
		query.executeUpdate();
	}

}
