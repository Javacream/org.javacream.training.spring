package org.javacream.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class DemoAspects{

	/*
	 * Jokerzeichen:
	 * * Beliebige Zeichenkette aber ohne Punkte
	 * ? Einzelnes Zeichen
	 * .. Beliebige Zeichenkette mit Punkt und Ende
	 * (..) Beliebige Parameterliste
	 */
	@Around("execution(* org.javacream..B.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
		String methodName = methodSignature.getMethod().getName();
		System.out.println("ASPECTJ: entering " + methodName);
		try {
			Object result = pjp.proceed();
			System.out.println("ASPECTJ: returning from " + methodName);
			return result;
		} catch (Throwable t) {
			System.out.println("ASPECTJ: throwing from " + methodName);
			throw t;
		}
	}
}
