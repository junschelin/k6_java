package com.ruby.java.ch02;

public class Test07 {
public static void main(String[] args) {
	int a = 10;
	int b,c = 0;
	
	b = ++a;
	c = a++;
	System.out.println("b="+ b + ", c="+c);
	System.out.println("a="+ a);
	boolean result = (b == c);
	System.out.println("result="+result);

	
	short e = 10;
	int f = -e; //부호연산자는 부호 변환 시 기본 int 형식으로 저장
	
	boolean isOn = false;
	while(!isOn){
		
	}


}
}
