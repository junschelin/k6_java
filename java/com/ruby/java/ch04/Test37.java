package com.ruby.java.ch04;

import java.util.Random;

public class Test37 {

	public static void main(String[] args) {
		
		//난수 생성하기
		Random rnd = new Random();
		int [] score = new int[20];
		int sum = 0; 
		int max = 0, min = 999;
		double avg;
		
		for (int i = 0; i < score.length; i++)
			score[i] = rnd.nextInt(100);
			
		for (int num: score)
			System.out.println(num);
		
		// 점수 4개씩 배열하기
		for (int i = 0; i < score.length; i++) {
			if (i%4 == 0)
				System.out.println();
			if (score[i] < 10)
				System.out.print(" ");
			System.out.print(score[i] + " " + "\n");
		}
			
						
		for(int i = 0; i<score.length; i++) {
			sum += score[i];
			if(max < score[i])
				max = score[i];
			if(min > score[i])
				min = score[i];
		}
		
		avg = sum / score.length;
		
		System.out.println("총 점 : " + sum);
		System.out.println("평 균 : " + avg);
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
		
		
		
		
	
		
		
	}

}
