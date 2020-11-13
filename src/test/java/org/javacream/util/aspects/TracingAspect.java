package org.javacream.util.aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Profile("test")
public class TracingAspect {

//	@Around("execution(public int org.javacream.store.impl.SimpleStoreService.getStock(String, String))")
//	@Around("execution(* org.javacream.store.impl.SimpleStoreService.getStock(String, String))")
//	@Around("execution(* org.javacream.store.impl.SimpleStoreService.getStock(String, ..))")
//	@Around("execution(* org.javacream.store.impl.SimpleStoreService.getStock(..))")
//	@Around("execution(* org.javacream.store.impl.SimpleStoreService.get*(..))")
//	@Around("execution(* org.javacream.store.impl.SimpleStoreService.*(..))")
//	@Around("execution(* org.javacream..SimpleStoreService.*(..))")
//	@Around("execution(* ..SimpleStoreService.*(..))") //falsch: .. beginnt und endet mit einem Punkt
//	@Around("execution(* org.javacream..SimpleStoreService.*(..))") 
	@Around("execution(* org.javacream..impl.*Service.*(..))") 
	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		String methodName = signature.getMethod().getName();
		System.out.println("entering " + methodName + "with params " + Arrays.asList(pjp.getArgs()));
		try {
			Object result = pjp.proceed();
			System.out.println("returning from " + methodName);
			return result;
		} catch (Throwable t) {
			System.out.println("throwing from " + methodName);
			throw t;
		}
	}

}
