package org.javacream.util.aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class TracingAspect {

	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		String methodName = methodSignature.getMethod().getName();
		System.out.println("entering " + methodName + " using args" + Arrays.asList(pjp.getArgs()));
		try {
			Object result = pjp.proceed();
			System.out.println("returning " + result + " from " + methodName);
			return result;
		} catch (Throwable t) {
			System.out.println("throwing " + t + " from " + methodName);
			throw t;
		}
	}

}
