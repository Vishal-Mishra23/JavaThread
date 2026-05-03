package com.ForkJoinExample;

import java.util.*;
import java.util.concurrent.*;

public class ForkJoinPractice extends RecursiveTask<List<String>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static List<String> lst;

	public ForkJoinPractice(List<String> lst) {
		this.lst = lst;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		List<String> resultList = new ArrayList<String>();
		List<String> forkList = addValues();
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ForkJoinPractice forkJoinPractice = new ForkJoinPractice(forkList);
		resultList = forkJoinPool.invoke(forkJoinPractice);
		System.out.println(resultList);
	}

	private static List<String> addValues() {
		return Arrays.asList("Hello", "Vishal", "Vidhu", "Mishra");

	}

	private static String addNameLengthTransform(String name) throws InterruptedException {
		Thread.sleep(100);
		return name.length() + " - " + name;
	}

	@Override
	protected List<String> compute() {
		if (lst.size() <= 1) {
			List<String> resultList = new ArrayList<>();
			lst.forEach(name -> {
				try {
					resultList.add(addNameLengthTransform(name));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			return resultList;
		}
		int midpoint = lst.size() / 2;
		ForkJoinTask<List<String>> leftlst = new ForkJoinPractice(lst.subList(0, midpoint)).fork();
		lst = lst.subList(midpoint, lst.size());
		List<String> rightResult = compute(); // recursion happens
		List<String> leftResult = leftlst.join();
		leftResult.addAll(rightResult);
		return leftResult;
	}

}
