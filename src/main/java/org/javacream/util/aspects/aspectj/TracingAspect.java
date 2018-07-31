package org.javacream.util.aspects.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TracingAspect {

	@Around("execution(* org.javacream..*Service.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		
		MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
		
		String name = methodSignature.getMethod().getName();
		System.out.println("ASPECTJ: entering " + name);
		try {
			Object result = pjp.proceed();
			System.out.println("ASPECTJ: returning from " + name);
			return result;
		} catch (Throwable e) {
			System.out.println("ASPECTJ: throwing from " + name);
			throw e;
		}
	}

}
