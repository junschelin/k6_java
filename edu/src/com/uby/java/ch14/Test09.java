package com.uby.java.ch14;

interface Calculatior{
	int func();
}

public class Test09 {
	
	static int num1 = 10;
	int num2 = 20;
	
	public static void main(String[] args) {
		Test09 test = new Test09();
		int num3 = 30;
		
		Calculatior calc = () -> {
			int num4 = 40;
			Test09.num1++;
			test.num2++;
			//num3++;
			num4++;
			return num4;
		};
	}
	
}
