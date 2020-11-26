package org.javacream.util.aspects;

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
	private long delay;

	@Around("execution(* org.javacream..impl.*Service.*(..))")
	public Object simulate(ProceedingJoinPoint pjp) throws Throwable {
		if (delay > 0) {
			System.out.println("delaying " + delay);
			Thread.sleep(delay);
		}
		Object[] clonedArgs = SerializationUtils.clone(pjp.getArgs());
		try {
			return SerializationUtils.clone((Serializable) pjp.proceed(clonedArgs));
		} catch (Throwable t) {
			throw SerializationUtils.clone(t);
		}
	}
}
