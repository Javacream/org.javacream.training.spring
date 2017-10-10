package org.javacream.util.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

//@Component @Aspect @Profile("test")
@AspectComponent
@Aspect
public class TracingAspect {

	@Around("execution(* org.javacream..impl.*.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable{
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

		System.out.println("tracing " + methodSignature.getName() + ", args=" + Arrays.asList(pjp.getArgs()));
		return pjp.proceed();
	}
}
