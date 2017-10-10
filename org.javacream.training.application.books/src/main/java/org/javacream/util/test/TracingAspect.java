package org.javacream.util.test;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

//@Component @Aspect @Profile("test")
@AspectComponent
@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TracingAspect {

	@Around("execution(* org.javacream..impl.*.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable{
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

		System.out.println("tracing " + methodSignature.getName() + ", args=" + Arrays.asList(pjp.getArgs()));
		return pjp.proceed();
	}
}
