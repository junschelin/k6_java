package com.uby.java.ch14;

interface MyInterface {
	public void print();
}

class MyClass1 implements MyInterface{
	@Override
	public void print() {
		System.out.println("MyClass1");
	}
}

class MyClass2 implements MyInterface{
	@Override
	public void print() {
		System.out.println("MyClass2");
	}
}

public class Test01 {
	public static void test(MyInterface mi) { // mi 객체의 print 메서드 실행
		mi.print();
	}
	
	public static MyInterface test2() { // MyInterface 타입을 반환하는 메서드
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("test2()메서드에서 반환된 MyInterface");
			}
		};
		return mi;
	}
	
	public static void main(String[] args) {
		
		MyClass1 mc1 = new MyClass1();
		MyClass2 mc2 = new MyClass2();
		mc1.print();
		mc2.print();		
	
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명 클래스로 구현");
			}
		};
		test(mc1);
		test(mi);
		
		mi.print();
		
		
		// 여기서부터 람다식?
		(new MyInterface() {
			@Override
			public void print() {
				System.out.println("선언, 생성, 호출을 한번에 처리");
			}
		}).print();
	
		MyInterface mi2 = test2();
		mi2.print();
	}
}
