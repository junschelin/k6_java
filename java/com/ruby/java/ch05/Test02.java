package com.ruby.java.ch05;

public class Test02 {

	static void test(String name, int ... v) {
		System.out.println(name + " : ");
		String namnam = name;
		for(int x : v)
			System.out.print(x + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		test("오정임", 98, 85, 88);
		test("김푸름", 90, 95, 92);
		test("김하늘", 80 ,98, 95);
	
	int num[] = {10, 20, 30};
	
	for(int i : num)
	System.out.print(i + " ");
		
	
	}
}
