package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(100)
public class MetricsAspect {

	@Around("execution(public int org.javacream.store.impl.MapStoreService.getStock(String, String))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature ms = (MethodSignature) pjp.getSignature();
		String methodName = ms.getMethod().getName();
		long start = System.currentTimeMillis();
		try {
			Object result = pjp.proceed();
			return result;
		} finally {
			System.out.println("calling " + methodName + " took " + (System.currentTimeMillis() - start) + "msec");
		}

	}
}
