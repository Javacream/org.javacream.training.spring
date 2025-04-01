package org.javacream.util.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMeasureAspect {

    @Around("execution(String org.javacream.books.isbngenerator.impl.*IsbnGenerator.next())||execution(int org.javacream.store.impl.SimpleStoreService.getStock(String, String))")
    public Object trace(ProceedingJoinPoint pjp) throws Throwable{
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getMethod().getName();
        long start = System.currentTimeMillis();
        try {
            return pjp.proceed(); // Aufruf das Delegationsobjekt
        }
        finally {
            System.out.println("calling " + methodName + " took " + (System.currentTimeMillis()-start) + "msec");
        }
    }


}
