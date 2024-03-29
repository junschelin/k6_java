package com.ruby.java.ch02;

public class Test3 {
public static void main(String[] args) {
	
	float exchageRate = (float)1236.50; //Type Casting
									//실수 Type에서 숫자 뒤 문자가 없으면 double로 간주
								  //정보손실 우려(8Byte -> 4Byte)로 인해 double을 4Byte로 표현 불가
	String st = "Good Day! How are you OK?";
	
	int num = 2147483647;
	int numSize = Integer.SIZE;
	System.out.println("numSize = " + numSize);
	
	long d = 2147483648L; //정수 Type에서 숫자 뒤 문자가 없으면 int로 간주 (기본 type : int)
	int dSize = Long.SIZE;
	System.out.println("dSize = " + dSize);
		
	}
	
}
