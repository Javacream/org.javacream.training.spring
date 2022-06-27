package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(5)
public class HugoReturnerAspect {

	@Around("execution(public String org.javacream..impl.*.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("**************************");
		return "Hugo";

	}
}
