package org.javacream.util.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {
    public Object trace(ProceedingJoinPoint pjp) throws Throwable{
        try {
            Object result = pjp.proceed(); // Aufruf das Delegationsobjekt
            return result;
        }
        catch(Throwable t){
            throw t;
        }
    }


}
