package org.javacream.util.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Profile("test")
public class TracingAspect {

//	@Around("execution(public int org.javacream.store.impl.SimpleStoreService.getStock(String, String))")
	@Around("execution(* org.javacream..*Service.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable{
		
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		String methodName = methodSignature.getName();
		System.out.println("entering method " + methodName);
		try {
			Object result = pjp.proceed();
			System.out.println("returning from method " + methodName);
			return result;
		}
		catch(Throwable t) {
			System.out.println("throwing from method " + methodName);
			throw t;
		}
		
	}
}
