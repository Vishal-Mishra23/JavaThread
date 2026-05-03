package com.ParallelStream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class parallelStreamEx {

	public static void main(String[] args) {
		List<String> lst = addValues();

		System.out.println(lst.parallelStream()
				.collect(Collectors.toMap(Function.identity(), String::length, (a, b) -> a, HashMap::new)));
		System.out.println(Runtime.getRuntime().availableProcessors());
		
	}

	private static List<String> addValues() {
		return Arrays.asList("Hello", "Vishal", "Vidhu", "Mishra");

	}

}
