package org.javacream.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class SimpleAspect {

	@Around("execution(* org.javacream..*.*(String, ..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable{
		Signature s = pjp.getSignature();
		MethodSignature methodSignature = (MethodSignature) s;
		System.out.println(" -> ASPECT <- entering method " + methodSignature.getName());
		Object result =  pjp.proceed();
		System.out.println(" -> ASPECT <- returning from method " + methodSignature.getName() + ", result= " + result);
		return result;
	}
}
