package com.ruby.java.ch04;

public class Test32_1 {

	public static void main(String[] args) {
		int[] score;
		score = new int[]{1,2,3,4,5,6,7};
		
		int num = score.length; // 배열에서는 length 뒤 괄호 필요 X
		System.out.println("num = " + num);
		
		String str = "nice day";
		int snum = str.length(); // Class에서는 length 뒤 괄호 필요
		
		int[]arr = new int[5];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		
		// 배열 출력 (기본)
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		
		// 배열 출력 (한번에)
		for (int i = 0; i <= arr.length; i++) {
			System.out.println(arr[i]);
			}
		
	}

}
