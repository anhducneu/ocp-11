package com.dd.core.extend.generic;

public class BoxPrinterTest {

	public static void main(String[] args) {
		BoxPrinter<String, Integer> printer = new BoxPrinter<>("Test", 123);

		System.out.println(printer.toString());

	}

}
