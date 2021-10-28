package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

//	@Around("execution(public int org.javacream.store.impl.SimpleStoreService.getStock(String, String))")
	//* beliebiger Rückgabewert oder beliebige Zeichenkette, (..) beliebige Parameterliste, .. beliebige TZichenkette mit beginnendem und endendem Punkt
	@Around("execution(* org.javacream..impl.*Service.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable{
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		System.out.println("tracing " + methodSignature.getName());
		Object result = pjp.proceed();
		return result;
	}
}
