package com.ruby.java.ch02;

public class Test16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte a = 23;
		int b = a;
		// a = b -> byte 타입(1byte)에 int 타입(4byte) 저장 불가. 타입 변환 필요 
		// a = byte(b);
		System.out.println(b);
		
		byte i = 10;
		byte j = 20;
		byte k = (byte)(i + j); // +연산 수행 시 숫자를 int로 변환해서 수행하기 때문에 타입 변환 필요
		
		
		
		byte c = 23;
		short d = 47;
		int e = 65;
		int f = c + d + e;
		
		
		
	}

}
