package com.ruby.java.ch04;

import java.util.Random;

public class Test39 {

	public static void main(String[] args) {

		//난수 생성하기
				Random rand = new Random();
				int arr[][] = new int[5][5];
				
				int num = rand.nextInt(100);
				for(int i = 0; i<arr.length; i++) {
					for(int j=0; j<arr[i].length; j++) {
						arr[i][j] = num++;
					}
				}
		for(int i =0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(i>=j)
					System.out.print(arr[i][j] + "\t");
				else
					System.out.print("\t");
			}
			System.out.println("\t");
		}
	}
}
