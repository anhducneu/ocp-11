package com.dd.core.extend.generic;

public class BoxPrinter<T1, T2> {

	private T1 val1;
	private T2 val2;

	public BoxPrinter(T1 arg1, T2 arg2) {
		val1 = arg1;
		val2 = arg2;
	}

	public String toString() {
		return "[" + val1 + ";" + val2 + "]";
	}

}
