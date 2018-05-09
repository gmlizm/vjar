package com.aboo.vjar.util.javassist;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodHandler;

public class XMethodHandler implements MethodHandler {

	@Override
	public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
		System.out.println(thisMethod.getName());
		System.out.println(proceed.getName());
		return proceed.invoke(self, args);
	}

}
