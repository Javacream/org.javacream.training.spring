package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

	// @Around("execution(sichtbarkeit rückgabetyp komplette signatur inklusive
	// packages, parameter)")
	// @Around("execution(public int
	// org.javacream.store.impl.MapStoreService.getStock(String, String))")
	@Around("execution(* org.javacream..impl.*.*(..))")	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		// vor der aspektierten Logik:
		System.out.println("before method invocation");
		// Aufruf der aspektierten Logik:
		Object result = pjp.proceed();
		// nach der aspektierten Logik:
		System.out.println("after method invocation");
		return result;

	}
}
