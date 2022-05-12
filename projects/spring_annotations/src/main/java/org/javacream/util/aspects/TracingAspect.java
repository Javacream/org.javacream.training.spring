package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

	@Around("execution(int org.javacream.store.impl.SimpleStoreService.getStock(String, String))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature)pjp.getSignature();
		String methodName = signature.getMethod().getName();
		System.out.println("entering " + methodName);
		try {
			Object result = pjp.proceed();
			System.out.println("returning from " + methodName);
			return result;
		} catch (Throwable t) {
			System.out.println("throwing from " + methodName);
			throw t;
		}
	}
}
