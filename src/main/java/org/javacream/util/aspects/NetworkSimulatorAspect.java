package org.javacream.util.aspects;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Profile("aop-on")
@Order(50)
public class NetworkSimulatorAspect {
	@Value("${network.delay}")
	private long delay;
	@Around("execution(* org.javacream..store.impl.*Service.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable{
		Thread.sleep(delay);
		Object[] args = pjp.getArgs();
		Object[] clonedArgs = SerializationUtils.clone(args);
		try {
			Object result = pjp.proceed(clonedArgs);
			return SerializationUtils.clone((Serializable) result);
		}
		catch(Throwable t) {
			throw SerializationUtils.clone(t);
		}
	}
}
