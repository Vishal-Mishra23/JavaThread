package com.ExecutorServices;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.ThreadsPractice.threadWithLock;
import com.thredsClass.Threds;


public class ExecutorServiceNewCachedThreadPool {

	@SuppressWarnings("unchecked")
	public static void executorService() throws InterruptedException, ExecutionException {
		AtomicInteger value = new AtomicInteger(5);
		Threds task = new Threds(value);
		Thread th = new Thread(task);

		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 100000; i++) {
			executor.execute(() -> {
				int result = performComputation();
				System.out.println(Thread.currentThread().getName() + "result" + result);
			});
		}
		executor.shutdown();
		Future<String> ft = (Future<String>) executor.submit(th);
		ft.get();
		Thread.sleep(1000);
		executor.wait(100000000);
		
		
		
		ThreadPoolExecutor executor1 = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(10), new ThreadPoolExecutor.AbortPolicy());
		for (int i = 0; i < 10; i++) {
			executor1.execute(() -> {
				int result = performComputation();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "result" + result);
			});
		}
		executor1.shutdown();
		System.out.println("Hello World!");
		ReentrantLock lock = new ReentrantLock();
		AtomicInteger num = new AtomicInteger(5);
		ExecutorService executor11 = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executor11.submit(new threadWithLock(num, lock));
			System.out.println(num);
		}

		executor11.shutdown();
		Thread.sleep(10000);
		System.out.println(Thread.currentThread().getName() + " " + num);
		executor11.shutdown();

		// Read-Write Lock

		ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
		ReadLock relock = rwlock.readLock();
		WriteLock wrlock = rwlock.writeLock();

	}

	private static int performComputation() {
		int sum = 0;
		for (int i = 0; i < 100000; i++) {

			sum += Math.sqrt(i);
		}
		return sum;
	}

}
