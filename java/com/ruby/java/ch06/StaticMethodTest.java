package com.ruby.java.ch06;

public class StaticMethodTest {
	static int num = 123;
	public static void main(String[] args) {
		StaticMethodTest.print1();
		print1();
		StaticMethodTest exam = new StaticMethodTest();
		exam.print2();
	}

	public static void print1() {
		int num2 = num;
		System.out.println("hello");
	}
	
	public void print2() {
		System.out.println("java");
	}
}
