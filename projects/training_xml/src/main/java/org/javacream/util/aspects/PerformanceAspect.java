package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class PerformanceAspect {
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
