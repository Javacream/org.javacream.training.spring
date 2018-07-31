package org.javacream.util.aspects.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TracingAspect implements InvocationHandler {
	Object delegate;

	public void setDelegate(Object delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String name = method.getName();
		System.out.println("entering " + name);
		try {
			Object result = method.invoke(delegate, args);
			System.out.println("returning from " + name);
			return result;
		} catch (Throwable e) {
			System.out.println("throwing from " + name);
			if (e instanceof InvocationTargetException) {
				e = ((InvocationTargetException) e).getTargetException();
			}
			throw e;
		}
	}

	public static <T> T createProxy(T toWrap){
		ClassLoader cl = TracingAspect.class.getClassLoader();
		Class[] interfaces = toWrap.getClass().getInterfaces();
		TracingAspect aspect = new TracingAspect();
		aspect.setDelegate(toWrap);
		return (T)Proxy.newProxyInstance(cl, interfaces, aspect);
	}
}
