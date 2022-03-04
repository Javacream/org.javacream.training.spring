package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;

public class TracingAspect {

	//@Around("execution(int org.javacream.store.impl.SimpleStoreService.getStock(String, String))")
	//@Around("execution(int org.javacream.store.impl.SimpleStoreService.getStock(..))") -> .. Beliebige Parameterliste
	//@Around("execution(int org.javacream.store.impl.*StoreService.*(..))") -> * Beliebige Zeichenkette, allerdings ohne Punkte
	//@Around("execution(* org.javacream.store.impl.*Service.*(..))") -> * Beliebige Zeichenkette, allerdings ohne Punkte
	@Around("execution(* org.javacream..*Service.*(..))") //-> .. Beliebige Zeichenkette mit führendem und endendem Punkt inklusive Punkte
	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		//Pures AspectJ -> Doku
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		String methodName = methodSignature.getMethod().getName();
		System.out.println("entering " + methodName);
		try {
			Object result = pjp.proceed();
			System.out.println("returning from " + methodName + ", result=" + result);
			return result;
		} catch (Throwable t) {
			System.out.println("throwing from " + methodName + ", throwable=" + t);
			throw t;

		}
	}
}
