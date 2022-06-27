package org.javacream.util.aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class TracingAspect {

	// @Around("execution(sichtbarkeit rückgabetyp komplette signatur inklusive
	// packages, parameter)")
	// @Around("execution(public int
	// org.javacream.store.impl.MapStoreService.getStock(String, String))")
	@Around("execution(* org.javacream..impl.*.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature ms = (MethodSignature) pjp.getSignature();
		String methodName = ms.getMethod().getName();
		System.out.println("entering " + methodName + ", params=" + Arrays.asList(pjp.getArgs()));
		try {
			Object result = pjp.proceed();
			System.out.println("returning from " + methodName + ", result= " + result);
			return result;
		} catch (Throwable t) {
			System.out.println("throwing from " + methodName + ", throwable= " + t);
			throw t;
		}

	}
}
