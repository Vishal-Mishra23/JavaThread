package com.thredsClass;

import java.util.concurrent.atomic.AtomicInteger;

public class Threds implements Runnable {

	AtomicInteger value;

	public Threds(AtomicInteger value) {
		super();
		this.value = value;
	}

	@Override
	public void run() {
//		try {
		add(value);
		System.out.println("Hello World");
//		}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private  void add(AtomicInteger val) {
		synchronized(val) {
			val.getAndAdd(5);
		}
		
		System.out.println(Thread.currentThread().getName() + " " + val);
	}

//	@Override
//	public  String call() throws Exception {
//		Thread.sleep(1000000);
//		// TODO Auto-generated method stub
//		return "Hello World";
//	}

}
