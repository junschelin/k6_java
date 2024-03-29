package com.uby.java.ch14;

interface NumberFunc{
	int func(int n);
}

interface NumberFunc1{
	int func(int n, int m);
}

public class Test05 {

	public static void main(String[] args) {
		NumberFunc sum = (n) -> {
			int result = 0;
			for(int i = 0; i <= n; i++) {
				result += i;
			}
			
			return result;
		};
		
		NumberFunc esum = (n) -> {
			int result = 0;
			for(int i = 0; i <= n; i++) {
				if (i % 2 == 0)
				result += i;
			}
			return result;
		};

		NumberFunc osum = (n) -> {
			int result = 0;
			for(int i = 0; i <= n; i++) {
				if (i % 2 != 0)
				result += i;
			}
			return result;
		};
		
		NumberFunc1 esum1 = (n, m) -> {
			int result = 0;
			for(int i = 0; i <= n; i++) {
				if (i % 2 == m)
				result += i;
			}
			return result;
		};

		NumberFunc1 osum1 = (n, m) -> {
			int result = 0;
			for(int i = 0; i <= n; i++) {
				if (i % 2 != m)
				result += i;
			}
			return result;
		};
		
		System.out.println("1부터 10까지의 합 : " + sum.func(10));
		System.out.println("1부터 100까지의 합 : " + sum.func(100));
		
		System.out.println("1부터 10까지의 홀수 합 : " + osum.func(10));
		System.out.println("1부터 10까지의 짝수 합 : " + esum.func(10));
		System.out.println("1부터 100까지의 홀수 합 : " + osum.func(100));
		System.out.println("1부터 100까지의 짝수 합 : " + esum.func(100));
		
		System.out.println("1부터 10까지의 홀수 합 : " + osum1.func(10,1));
		System.out.println("1부터 10까지의 짝수 합 : " + esum1.func(10,0));
		System.out.println("1부터 100까지의 홀수 합 : " + osum1.func(100,1));
		System.out.println("1부터 100까지의 짝수 합 : " + esum1.func(100,0));
	}
}
