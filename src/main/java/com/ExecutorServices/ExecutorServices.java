package com.ExecutorServices;

import java.util.concurrent.*;
import org.apache.commons.lang3.time.StopWatch;

public class ExecutorServices {

	static StopWatch stopwatch = new StopWatch();

	public static void executorExample(String[] args) throws InterruptedException, ExecutionException {

		stopwatch.start();
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		Future<Integer> sumResp = executorService.submit(() -> sum(5, 6));
		Future<Integer> mulResp = executorService.submit(() -> multiple(5, 6));

		Integer sumRespInteger = sumResp.get();
		Integer mulRespInteger = mulResp.get();
		executorService.shutdown();
		stopwatch.stop();
		System.out.println("Time taken: " + stopwatch.getTime());
	}

	public static int sum(int a, int b) throws InterruptedException {
		Thread.sleep(1000);
		return a + b;
	}

	public static int multiple(int a, int b) throws InterruptedException {
		Thread.sleep(1000);
		return a * b;
	}

}
