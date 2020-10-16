package org.javacream.util.aspect;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Profile("test")
public class NetworkSimulatorAspect {
	@Value("${network.delay}")
	long delay;

	@Around("execution(* org.javacream..api.*Service.*(..))")
	public Object simulate(ProceedingJoinPoint pjp) throws Throwable {
		if (delay > 0) {
			Thread.sleep(delay);
			System.out.println("delaying " + delay);
		}
		Object[] clonedArgs = SerializationUtils.clone(pjp.getArgs());
		try {
			return SerializationUtils.clone((Serializable) pjp.proceed(clonedArgs));
		} catch (Throwable t) {
			throw SerializationUtils.clone(t);
		}
	}

}
