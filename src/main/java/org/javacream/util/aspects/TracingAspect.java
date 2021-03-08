package org.javacream.util.aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(50)
public class TracingAspect {

	// @Around("execution(String
	// org.javacream.books.warehouse.impl.MapBooksService.newBook(String))")
	// @Around("execution(* org.javacream..impl.*Service.*(..)) || execution(String
	// org.javacream..impl.*IsbnGenerator.next())")
	@Around("execution(* org.javacream..impl.*Service.*(..))")
	public Object trace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
		System.out.println("entering method " + signature.getMethod().getName() + ", type="
				+ signature.getDeclaringTypeName() + ", args=" + Arrays.asList(proceedingJoinPoint.getArgs()));
		try {
			Object result = proceedingJoinPoint.proceed();
			System.out.println("returning from " + signature.getMethod().getName() + ", result=" + result);
			return result;
		} catch (Throwable t) {
			System.out.println("throwing from " + signature.getMethod().getName() + ", exception=" + t);
			throw t;

		}
	}
}
