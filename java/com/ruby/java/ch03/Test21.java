package com.ruby.java.ch03;

import java.io.IOException;

public class Test21 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//char를 입력 받을 때는 (char)System.in.read 메서드를 이용한다.
		System.out.print("문자 : ");
		char op;
		op = (char)System.in.read();
		
				
		int a = 12;
		int b = 2;
		
		if(op == '+') {
			System.out.println(a + b);
		} else if(op == '-') {
			System.out.println(a - b);
		} else if(op == '*') {
			System.out.println(a * b);
		} else if(op == '/') {
			System.out.println(a / b);
		}
	}
}
