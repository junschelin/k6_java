package com.ruby.java.ch03;

import java.util.Scanner;

public class Test_Sosu_Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 숫자 하나 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.println("num : ");
		int num = sc.nextInt();
		
		boolean flag = false;
		for(int i = 2; i < num; i++) {
			if(num % i ==0) {
				flag = true;
				break;
			}
		}
		System.out.println(flag?"소수가 아닙니다.":"소수입니다.");
		sc.close();
	}

}
