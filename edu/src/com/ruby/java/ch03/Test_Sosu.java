// 임의의 숫자 하나 입력 받아서 소수인지 아닌지 판단하기

package com.ruby.java.ch03;

import java.util.Scanner;

public class Test_Sosu {

	public static void main(String[] args) {
		
		//숫자 하나 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.print("num : ");
		int num = sc.nextInt();
		int cnt = 0;
		
		for(int i=2 ; i<num; i++) {
			if(num % i == 0) 
				cnt ++;
		}
		if (cnt >= 2 | num == 1 ) {
		System.out.println("소수가 아닙니다.");		
		} else {
		System.out.println("소수입니다.");
		}
	}
}
