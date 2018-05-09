package com.aboo.vjar.util.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class XMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println(proxy.getSuperName());
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("****************");
		return result;
	}

}
