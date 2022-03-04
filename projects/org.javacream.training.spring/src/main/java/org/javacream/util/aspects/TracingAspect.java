package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class TracingAspect {

	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		//Pures AspectJ -> Doku
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		String methodName = methodSignature.getMethod().getName();
		System.out.println("entering " + methodName);
		try {
			Object result = pjp.proceed();
			System.out.println("returning from " + methodName + ", result=" + result);
			return result;
		} catch (Throwable t) {
			System.out.println("throwing from " + methodName + ", throwable=" + t);
			throw t;

		}
	}
}
