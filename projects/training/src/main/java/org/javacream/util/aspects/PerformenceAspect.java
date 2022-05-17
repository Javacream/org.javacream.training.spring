package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformenceAspect {
	@Around("execution(* org.javacream..impl.*Service.*(..))")
	public Object measure(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String methodName = ((MethodSignature)proceedingJoinPoint.getSignature()).getMethod().getName();
		long start = System.currentTimeMillis();
		try {
			return proceedingJoinPoint.proceed();
		}
		finally{
			System.out.println("calling " + methodName + " took " + (System.currentTimeMillis() - start) + " msec");
		}
	}

}
