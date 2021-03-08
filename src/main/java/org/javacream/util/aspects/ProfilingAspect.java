package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class ProfilingAspect {

	@Around("execution(* org.javacream..impl.*Service.*(..))")
	public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
		try {
			Object result = proceedingJoinPoint.proceed();
			return result;
		} catch (Throwable t) {
			throw t;
		}
		finally {
			System.out.println("calling " + signature.getMethod().getName() + " took " + (System.currentTimeMillis() - start) + "msec");
		}
	}
}
