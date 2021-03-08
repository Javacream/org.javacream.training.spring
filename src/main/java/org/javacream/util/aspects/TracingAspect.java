package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

	//@Around("execution(String org.javacream.books.warehouse.impl.MapBooksService.newBook(String))")
	//@Around("execution(* org.javacream..impl.*Service.*(..)) || execution(String org.javacream..impl.*IsbnGenerator.next())")
	@Around("execution(* org.javacream..impl.*Service.*(..))")
	public Object trace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
		System.out.println("******** execution of method " + signature.getMethod().getName());
		Object result = proceedingJoinPoint.proceed();
		return result;
	}
}
