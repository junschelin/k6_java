// 구구단 좌 -> 우 방향으로 2*1 = 2 3*1 = 3
//					  2*2 = 4 3*2 = 6

package com.ruby.java.ch03;

public class Test31_T {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j< 10; j++) {
				System.out.print(i + "*" + j + "=" + (i * j) + " ");
			}
			System.out.println("\n"); // 한 줄 바꿈
		}
		
	}
}
