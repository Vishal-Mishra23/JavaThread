package com.ThreadsPractice;

import java.util.concurrent.Callable;

public class readWriteExmaple implements Callable<Integer> {
	String type;
	int value;

	/**
	 * @param type
	 * @param value
	 */
	public readWriteExmaple(String type, int value) {
		super();
		this.type = type;
		this.value = value;
	}

	public readWriteExmaple(String type) {
		super();
		this.type = type;
	}

	@Override
	public Integer call() throws Exception {
		if (this.type.equalsIgnoreCase("read")) {
			return readValue();
		} else {
			return writeValue(this.value);
		}

		// TODO Auto-generated method stub
	}

	private Integer readValue() {
		System.out.println(value);
		return this.value;

	}

	private Integer writeValue(int val) {
		val += 10;
		return this.value;
	}

}
