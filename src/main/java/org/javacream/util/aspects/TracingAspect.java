package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TracingAspect {

    @Around("execution(* org.javacream..impl.*.*(..))")
    public Object trace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        System.out.println("entering " + methodName);
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println("returning from " + methodName + ", result=" + result);
            return result;
        } catch (Throwable t) {
            System.out.println("returning from " + methodName + ", throwable=" + t);
            throw t;

        }

    }
}
