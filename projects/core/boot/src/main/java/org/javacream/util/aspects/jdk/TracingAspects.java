package org.javacream.util.aspects.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TracingAspects implements InvocationHandler{

	private Object delegate;

	public void setDelegate(Object delegate) {
		this.delegate = delegate;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		System.out.println("entering " + methodName);
		try {
			Object result = method.invoke(delegate, args);
			System.out.println("returning from " + methodName);
			return result;
		} catch (Throwable t) {
			System.out.println("throwing from " + methodName);
			if (t instanceof InvocationTargetException) {
				t = ((InvocationTargetException)t).getTargetException();
			}
			throw t;
		}
	}
	
	public static <T> T decorate(T delegate) {
		TracingAspects tracingAspect = new TracingAspects();
		tracingAspect.setDelegate(delegate);
		ClassLoader classLoader = TracingAspects.class.getClassLoader();
		Class<?>[] interfacesToImplement = delegate.getClass().getInterfaces();
		return (T)Proxy.newProxyInstance(classLoader, interfacesToImplement, tracingAspect);
	}
}
