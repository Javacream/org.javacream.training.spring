package org.javacream.util.util.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkTracingAspect implements InvocationHandler {
    public JdkTracingAspect(Object delegate) {
        this.delegate = delegate;
    }

    private Object delegate;
    @Override
    public Object invoke(Object proxyNotUsedAtAll, Method method, Object[] params) throws Throwable {
        System.out.println("entering " + method.getName());
        Object result = method.invoke(delegate, params);
        return result;
    }

    public static <T> T wrap(T object){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InvocationHandler handler = new JdkTracingAspect(object);
        Class<?>[] toImplement = object.getClass().getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, toImplement, handler);
    }
}
