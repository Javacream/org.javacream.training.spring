package org.javacream.util.aspects;

public class TracingAspect {
	
	public Object trace() throws Throwable{
		System.out.println("entering... ");
		try {
			Object result = new Object();
			System.out.println("returning from ... ");
			return result;
		}
		catch(Throwable t) {
			System.out.println("throwing from ... ");
			throw t;
		}
	}

}
