//정수의 자릿수를 입력 받아서 해당 자릿수에 속하는 소수를 찾아서 출력하는 프로그램을 작성해 보세요.

package com.ruby.java.ch03;

import java.util.Scanner;

public class Test_Sosu_2 {

	public static void main(String[] args) {

		// 숫자 하나 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.println("num : ");
		int num = sc.nextInt();
		boolean flag = false;
		
		//자리수 만들기
		int size = 10;
		for (int i = 1 ; i < num; i++) {
			size = size * 10;
		}
		
		for (int i = 2; i < size; i++) {
			if (num % i == 0) {
				System.out.println(num);
			}
		}
	}

}
