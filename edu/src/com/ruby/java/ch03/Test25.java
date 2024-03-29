package com.ruby.java.ch03;
import java.util.Scanner;

public class Test25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("i : ");
		int i = sc.nextInt();
		int sum = 0;
		
		
		for(;i < 10; i++) {
			System.out.println(i);
			sum += i;
		}
		System.out.println(sum);
	}

}
