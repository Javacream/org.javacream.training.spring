package org.javacream.util.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class Tracing  {
    public Object trace(ProceedingJoinPoint pjp) throws Throwable{
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        String methodName = signature.getMethod().getName();
        System.out.println("entering " + methodName);
        try {
            Object result = pjp.proceed();
            System.out.println("returning from " + methodName + ", result=" + result);
            return result;
        }
        catch(Throwable t){
            System.out.println("throwing from " + methodName + ", throwable=" + t);
            throw t;
        }

    }
}

