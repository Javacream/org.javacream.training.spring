package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

	public Object trace(ProceedingJoinPoint pjp) {
		//vor der aspektierten Logik:
		System.out.println("before method invocation");
		//Aufruf der aspektierten Logik:
		Object result = pjp.proceed();
		//nach der aspektierten Logik:
		System.out.println("after method invocation");
		return result;
		
	}
}
