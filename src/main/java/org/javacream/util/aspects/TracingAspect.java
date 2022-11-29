package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Profile("aop-on")
@Order(10)

public class TracingAspect {

	//@Around("execution(public String org.javacream.books.isbngenerator.impl.IsbnGeneratorImpl.next())")
	//* Eine Zeichenkette exklusive Punkt '.'
	//.. innerhalb einer Methoden-Klammerung ist eine beliebige Parameterliste
	//.. innerhalb einer Zeichenkette ist ein Platzhalter inklusive Punkte aber immmer mit beginnendem und endenden Punkt
	@Around("execution(* org.javacream..impl.*Service.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable{
		MethodSignature signature=  (MethodSignature) pjp.getSignature();
		String methodName = signature.getMethod().getName();
		System.out.println("entering " + methodName);
		try {
			Object result = pjp.proceed();
			System.out.println("returning from " + methodName);
			return result;
		}
		catch(Throwable t) {
			System.out.println("throwing from " + methodName);
			throw t;
			
		}
	}
}
