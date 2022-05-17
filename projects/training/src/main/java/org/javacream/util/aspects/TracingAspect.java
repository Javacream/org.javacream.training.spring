package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TracingAspect {
	
	@Around("execution(public int org.javacream.store.impl.SimpleStoreService.getStock(String, String))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("entering... ");
		try {
			Object result = pjp.proceed();
			System.out.println("returning from ... ");
			return result;
		}
		catch(Throwable t) {
			System.out.println("throwing from ... ");
			throw t;
		}
	}

}
