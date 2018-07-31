package org.javacream.util.aspects.aopalliance;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TracingAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		
		String name = methodInvocation.getMethod().getName();
		System.out.println("AOPALLIANCE: entering " + name);
		try {
			Object result = methodInvocation.proceed();
			System.out.println("AOPALLIANCE: returning from " + name);
			return result;
		} catch (Throwable e) {
			System.out.println("AOPALLIANCE: throwing from " + name);
			throw e;
		}
	}

}
