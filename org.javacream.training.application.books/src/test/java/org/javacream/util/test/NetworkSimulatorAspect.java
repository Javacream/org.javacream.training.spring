package org.javacream.util.test;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Profile("networktest")
public class NetworkSimulatorAspect {
	@Value ("${test.network.delay}")
	private long delay;

	@Around("execution(* org.javacream..*Service.*(..)) && !execution(* org.javacream..*RestService.*(..)) || execution(* org.javacream.books.isbngenerator.impl.*IsbnGenerator.next())")
	public Object simulate(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		System.out.println("Simulating network on " + methodSignature.getName() +", delay=" + delay);
		Thread.sleep(delay);
		Object[] args = pjp.getArgs();
		Object[] serializedArgs = SerializationUtils.clone(args);
		try {
			Object result = pjp.proceed(serializedArgs);
			Object serializedResult = SerializationUtils.clone((Serializable) result);
			return serializedResult;
		} catch (Throwable t) {
			throw SerializationUtils.clone(t);
		}
	}
}
