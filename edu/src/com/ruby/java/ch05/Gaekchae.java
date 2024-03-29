package com.ruby.java.ch05;

public class Gaekchae {

	public static void main(String[] args) {
		
		System.out.println("1");
		
		// debugging 할 때 메서드 안으로 들어갈 때는 <F5>
		
		String num = takeoff(6, 7);
		System.out.println(num);
				
		System.out.println("2");		
	}

	static String takeoff(int num1, int num2) {
		
		System.out.println("take off1");
		System.out.println("take off1");
		System.out.println("take off1");
		
		return num1 + " ===>";
	}	
}
