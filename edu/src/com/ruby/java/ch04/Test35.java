package com.ruby.java.ch04;

public class Test35 {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30, 40 ,50};
		
		
		// 확장형 For문
		for(int num : arr) {
			System.out.println(num);
		}	
		// String 배열 원소 전부 출력
		String st[] = {"apple", "banana", "peach"};
		for (String stx: st)
			System.out.println(stx);
		System.out.println(st.length);
		
		
		
		// 배열 원소 전부 출력 (간결한 코딩)
		for (int num: arr)
			System.out.println(num);
		
	}
}
