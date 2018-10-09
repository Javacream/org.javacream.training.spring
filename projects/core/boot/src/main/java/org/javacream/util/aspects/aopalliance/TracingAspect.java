package org.javacream.util.aspects.aopalliance;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TracingAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = methodInvocation.getMethod().getName();
		System.out.println("AOPALLIANCE: entering " + methodName);
		try {
			Object result = methodInvocation.proceed();
			System.out.println("AOPALLIANCE: returning from " + methodName);
			return result;
		} catch (Throwable t) {
			System.out.println("AOPALLIANCE: throwing from " + methodName);
			throw t;
		}
	}
}
