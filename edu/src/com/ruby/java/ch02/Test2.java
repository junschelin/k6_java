package com.ruby.java.ch02;

public class Test2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int depositAmount = 50000;
		float ratio = 0.14f; //실수 타입 뒤에는 f
		boolean result = true;
		result = false;
		
		char gender = 'F';
		char c = '\u0057';
		
		String greeting = "good morning"; //String : 자바 내부에 포함된 클래스 이름
		
		System.out.println("code = " + c + ", gender : " + gender);
		System.out.println(result);
		System.out.print("\n저금액 : " + depositAmount);
	}

}
