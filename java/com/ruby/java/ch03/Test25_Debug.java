package com.ruby.java.ch03;

import java.util.Scanner;

public class Test25_Debug {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			System.out.print("i : ");
			int i = sc.nextInt();
			int Even = 0, Odd = 0;
			
			
			for(;i < 10; i++) {
				
				if(i % 2 == 0) {
					Even += i;
					System.out.println("짝수의 합은 : "+Even);
				} else {
					Odd += i;
					System.out.println("홀수의 합은 : "+Odd);
				}
				
			}
			System.out.println("짝수의 합은 : "+Even);
			System.out.println("홀수의 합은 : "+Odd);
		}

}


