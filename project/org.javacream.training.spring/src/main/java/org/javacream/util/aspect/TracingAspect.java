package org.javacream.util.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

//	@Around("execution(public int org.javacream.store.impl.SimpleStoreService.getStock(String, String))")
	@Around("execution(* org.javacream..*Service.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable{
		MethodSignature ms = (MethodSignature) pjp.getSignature();
		System.out.println("********  Trace method " + ms.getName());
		return pjp.proceed();
		
	}
}
