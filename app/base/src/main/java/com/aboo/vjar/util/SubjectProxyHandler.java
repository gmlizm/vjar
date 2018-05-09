package com.aboo.vjar.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectProxyHandler implements InvocationHandler {

	private Object proxied;

	public SubjectProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 在转调具体目标对象之前，可以执行一些功能处理
		System.out.println("代理调用前");
		// 转调具体目标对象的方法
		Object obj = method.invoke(proxied, args);

		// 在转调具体目标对象之后，可以执行一些功能处理
		System.out.println("代理调用后");
		
		return obj;
	}

}
