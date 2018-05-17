package com.aboo.vjar.test.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import org.objenesis.strategy.StdInstantiatorStrategy;

import com.aboo.vjar.data.model.User;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.pool.KryoFactory;
import com.esotericsoftware.kryo.pool.KryoPool;

/**
 * http://x-rip.iteye.com/blog/1555344
 * 几种序列化方式对比
 * https://blog.csdn.net/qq_21033663/article/details/52026716
 * @author lizm
 *
 */
public class KryoTest {
	
	private static KryoFactory KRYOFACTORY = new KryoFactory() {
		public Kryo create() {
			Kryo kryo = new Kryo();
			return kryo;
		}
	};

	private static KryoPool KRYOPOOL = new KryoPool.Builder(KRYOFACTORY).build();
	private static String SERIAL_PATH = "/opt/test/kryo/";
	private static String SERIAL_FILE = "test.bin";
	private static String SERIAL_FILEPATH = SERIAL_PATH+SERIAL_FILE;

	public static void serialize(Object obj) throws Exception {
		Kryo kryo = KRYOPOOL.borrow();
		//kryo.register(User.class);
		kryo.setReferences(false);  
		kryo.setRegistrationRequired(false);  
		kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());  
		File file = new File(SERIAL_PATH);
		if(!file.exists()) {
			file.mkdirs();
		}
		Output output = new Output(new FileOutputStream(SERIAL_FILEPATH));
		kryo.writeClassAndObject(output, obj);
		output.close();
		KRYOPOOL.release(kryo);
	}
	
	public static <T> void deserialize(Class<T> clazz) throws Exception {
		Kryo kryo = KRYOPOOL.borrow();
		
		Input input = new Input(new FileInputStream(SERIAL_FILEPATH));
		//====================================
		FileInputStream inputStream = new FileInputStream(SERIAL_FILEPATH);
		byte[] data = new byte[inputStream.available()];
		inputStream.read(data, 0, data.length);
		System.out.println(Arrays.toString(data));
		System.out.println(new String(data,"ISO-8859-1"));
		inputStream.close();
		//====================================
		T result = kryo.readObject(input, clazz);
		//System.out.println(ToStringBuilder.reflectionToString(result));
		input.close();
		KRYOPOOL.release(kryo);
	}

	public static void main(String[] args) throws Throwable {
		User user = new User();
		user.setUserId(5);
		user.setUserName("YYYY");
		serialize(user);
		deserialize(User.class);
		System.out.println((char)0xE5);
	}

}
