package com.completableFuture;

import java.util.concurrent.CompletableFuture;

public class completableFuturePractice {

	public static void main(String[] args) {
		CompletableFuture.supplyAsync(() -> completableFuturePractice.helloWorld())
		.thenApply(String::toUpperCase)
        .thenApply((s) -> s.length() + " - " + s)
				.thenAccept(result -> {
					System.out.println(result);
				}).join();
		
		
		CompletableFuture<String>res1 =  CompletableFuture.supplyAsync(() -> completableFuturePractice.helloWorld());
		
		CompletableFuture<String>res2 = CompletableFuture.supplyAsync(() -> completableFuturePractice.hiWorld());
		
		res1.thenCombine(res2,(resp , response)->{
			return resp+" "+response;
			
		}).thenApply(String::toUpperCase).thenAccept(System.out::println)
		 .join();
		
		
 
	}

	public static String helloWorld() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hello world";
	}
	
public static String hiWorld() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hi world";
	}

}
