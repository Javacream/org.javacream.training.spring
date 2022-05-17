package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TracingAspect {
	
	//@Around("execution(public int org.javacream.store.impl.SimpleStoreService.getStock(String, String))")
	@Around("execution(* org.javacream..impl.*Service.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable{
		MethodSignature methodSignature =  (MethodSignature) pjp.getSignature();
		String methodName = methodSignature.getMethod().getName();
		System.out.println("entering " + methodName);
		try {
			Object result = pjp.proceed();
			System.out.println("returning from " + methodName);
			return result;
		}
		catch(Throwable t) {
			System.out.println("throwing from " + methodName);
			throw t;
		}
	}

}
