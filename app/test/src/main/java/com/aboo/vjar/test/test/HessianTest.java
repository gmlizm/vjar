package com.aboo.vjar.test.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import com.aboo.vjar.data.model.User;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

public class HessianTest {

	public static byte[] serialize(Object data) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Hessian2Output out = new Hessian2Output(bos);
		out.writeObject(data);
		out.flush();
		return bos.toByteArray();
	}

	public static <T> T deserialize(byte[] bytes, Class<T> clz) throws IOException {
		Hessian2Input input = new Hessian2Input(new ByteArrayInputStream(bytes));
		return (T) input.readObject(clz);
	}

	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setUserId(3);
		user.setUserName("xxxx");
		byte[] data = serialize(user);
		System.out.println(Arrays.toString(data));
		System.out.println(new String(data, "ISO-8859-1"));
		deserialize(data, User.class);
	}
}
