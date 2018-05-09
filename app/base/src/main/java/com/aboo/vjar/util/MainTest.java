package com.aboo.vjar.util;

public class MainTest {

	/*public static void main(String[] args) {

		RealSubject real = new RealSubject();
		Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
				new Class[] { Subject.class }, new SubjectProxyHandler(real));

		proxySubject.doSomething();

		String name = "ProxySubject";
		byte[] data = ProxyGenerator.generateProxyClass(name, new Class[] { Subject.class });
		
		try {
			FileOutputStream out = new FileOutputStream("D:/" + name + ".class");
			out.write(data);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
