package com.ruby.java.ch03;

public class Test29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 0) 
				continue; // 조건문 뒤 실행문 한 줄만 올 때는 중괄호 생략 가능
		
			System.out.println(i);
		}
	}
}
