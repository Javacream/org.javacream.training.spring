package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Aspect
@Profile("aop")
@Order(10)
public class TracingAspect{

    @Around("execution(* org.javacream..impl.*Service.*(..))")
    public Object trace(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature=  (MethodSignature) pjp.getSignature();
        String methodName = signature.getMethod().getName();
        String className = pjp.getTarget().getClass().getName();
        String info = "method " + methodName + " of class " + className;
        System.out.println("entering " + info);
        try {
            Object result = pjp.proceed();
            System.out.println("returning from " + info);
            return result;
        }
        catch(Throwable t) {
            System.out.println("throwing from " + info);
            throw t;

        }
    }
}
