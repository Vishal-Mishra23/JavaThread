package com.thredsClass;

import java.util.concurrent.atomic.AtomicInteger;

public class RunablePractice {
	
	public void runnablePractice() throws InterruptedException {
		AtomicInteger value = new AtomicInteger(5);
		Threds task = new Threds(value);
		Threds task1 = new Threds(value);
		Threds task2 = new Threds(value);
		Threds task3 = new Threds(value);
		Threds task4 = new Threds(value);

		Thread th = new Thread(task);
		Thread th1 = new Thread(task);
		Thread th2 = new Thread(task);
		Thread th3 = new Thread(task);
		Thread th4 = new Thread(task);

		th.start();
		th1.start();
		th3.start();
		th2.start();
		th4.start();

		th.join();
		th1.join();
		th3.join();
		th2.join();
		th4.join();
		final int Num_Core = Runtime.getRuntime().availableProcessors();
		System.out.println(Num_Core);
	}

}
