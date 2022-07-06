package org.javacream.util.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(100)
public class TimeMeasure {
    @Around("execution(* org.javacream..impl.*.*(..))")
    public Object measure(ProceedingJoinPoint pjp) throws Throwable{
        long start = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        String methodName = signature.getMethod().getName();
        try {
            Object result = pjp.proceed();
            return result;
        }
        catch(Throwable t){
            throw t;
        }
        finally{
            System.out.println("calling " + methodName + " took " + (System.currentTimeMillis() - start) + "msec");
        }

    }
}

