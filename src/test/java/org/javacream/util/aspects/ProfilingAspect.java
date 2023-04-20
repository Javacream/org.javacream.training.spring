package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

    @Component
    @Aspect
    @Profile("aop")
    @Order(5)
    public class ProfilingAspect {

        @Around("execution(* org.javacream..impl.*Service.*(..))")
        public Object profile(ProceedingJoinPoint pjp) throws Throwable{
            MethodSignature signature=  (MethodSignature) pjp.getSignature();
            String methodName = signature.getMethod().getName();
            long start = System.currentTimeMillis();
            try {
                return pjp.proceed();
            }
            finally {
                System.out.println("calling " + methodName + " took " + (System.currentTimeMillis() - start + " msec"));
            }
        }
    }

