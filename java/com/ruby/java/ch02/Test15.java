package com.ruby.java.ch02;

public class Test15 {
public static void main(String[] args) {
	

	
	char c = 'F';
	String gender;
	if (c == 'F')
		gender = "여자";
	else
		gender = "남자";
	System.out.println(gender);
	
	
	//삼항 연산 : ** = (if) (**) ? : then true일 때 ":" : else false일 때 
	
	String Gender = (c == 'F') ? "여자" : "남자";
	System.out.println(Gender);
	
}
}