package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

	@Around("execution(public String org.javacream.books.isbngenerator.impl.IsbnGeneratorImpl.next())")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("entering method");
		try {
			Object result = pjp.proceed();
			System.out.println("returning from...");
			return result;
		}
		catch(Throwable t) {
			System.out.println("throwing from...");
			throw t;
			
		}
	}
}
