package org.javacream.util.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class TracingAspect {

	@Around("execution(* org.javacream..impl.*.*(..))")
	public Object trace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
		String methodName = methodSignature.getMethod().getName();
		try {
			System.out.println("entering method " + methodName);
			Object result =  proceedingJoinPoint.proceed();
			System.out.println("returning from method " + methodName);
			return result;
		}catch(Throwable t) {
			System.out.println("throwing from method " + methodName);
			throw t;
		}
		
	}
}
