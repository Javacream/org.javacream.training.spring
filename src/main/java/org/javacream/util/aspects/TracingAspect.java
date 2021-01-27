package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component
@Aspect
public class TracingAspect{

    @Around("execution (* org.javacream..impl.*Service.*(..))")
    public Object trace(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        System.out.println("entering method " + signature.getMethod().getName());
        Object result = pjp.proceed();

        return result;
    }

}
