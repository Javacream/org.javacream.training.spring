package org.javacream.util.aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

//	@Around("execution(public int org.javacream.store.impl.SimpleStoreService.getStock(String, String))")
	// * beliebiger Rückgabewert oder beliebige Zeichenkette, (..) beliebige
	// Parameterliste, .. beliebige TZichenkette mit beginnendem und endendem Punkt
	//@Around("execution(* org.javacream..impl.*Service.*(..))")
	@Around("@annotation(org.javacream.util.aspects.Traced)")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable{
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		String methodName = methodSignature.getName();
		System.out.println("entering " + methodName +", params=" + Arrays.asList(pjp.getArgs()));
		try {
			Object result = pjp.proceed();
			System.out.println("returning from " + methodName + ", result=" + result);
			return result;
		}
		catch(Throwable t) {
			System.out.println("throwing from " + methodName + ", exception=" + t);
			throw t;
		}
	}
}
