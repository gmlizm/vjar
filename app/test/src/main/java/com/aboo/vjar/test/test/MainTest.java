package com.aboo.vjar.test.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainTest {
	
	public static void main(String[] args) {
		final ThreadPoolExecutor executor = new ThreadPoolExecutor(0,3,2,TimeUnit.MICROSECONDS,new SynchronousQueue<>());
//		final ThreadPoolExecutor executor = new ThreadPoolExecutor(0,3,2,TimeUnit.MICROSECONDS,new LinkedBlockingQueue<>(50));
		
		int reject = 0;
		for(int i=0;i<200;i++) {
			
			try {
				TimeUnit.MICROSECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				executor.submit(new Task(i));
			}catch(RejectedExecutionException e) {
				reject++;
				e.printStackTrace();
			}
		}
		
		try {
			TimeUnit.MICROSECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("共拒绝任务数： "+ reject);
	}
	
	static class Task implements Runnable{
		
		private int index;
		
		public Task(int index) {
			this.index = index;
		}

		@Override
		public void run() {
			try {
				TimeUnit.MICROSECONDS.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("synchronous test ===> "+ index);
			
		}
		
	}

}
