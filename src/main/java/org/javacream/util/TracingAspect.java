package org.javacream.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {
    //Abfragesprache wie SQL, XPath, CSS-Selector, AspectJ erfindet seine eigene Abfragesprache
    //@Around("execution(public String org.javacream.books.isbngenerator.impl.RandomIsbnGenerator.next())")
    @Around("execution(* org.javacream..impl.*.*(..))")
    public Object trace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getMethod().getName();
        System.out.println("entering " + methodName);
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println("returning from " + methodName);
            return result;
        }catch(Throwable t){
            System.out.println("throwing from " + methodName);
            throw t;

        }
    }
}
