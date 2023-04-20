package org.javacream.util.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Aspect
public class TracingAspect{

    @Around("execution(* org.javacream..impl.*Service.*(..))")
    public Object trace(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        String methodName = ms.getMethod().getName();
        System.out.println("ASPECTJ: calling " + methodName);
        return pjp.proceed();
    }
}
