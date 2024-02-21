package com.ruby.java.ch04;

import java.util.Random;

/*
 * 하나의 자바 파일에서 함수 구현 실습
 */
public class Assignment_Matrix {
	/*
	 * 행렬 덧셈, 곱셈 연산 메소드 정의
	 * 1차버젼: 덧셈후 바로 출력
	 * 2차버젼: 덧셈후 return 값으로 결과 행렬 반환
	 */
	// 난수 저장할 변수
	static Random rand = new Random();
	//B,C,E 행렬 크기 설정
	static int B[][] = new int[3][4];
	static int C[][] = new int[3][4];
	static int E[][] = new int[4][5];
	
	
	static void showMatrix(int [][]X) {
		//2차원 모습으로 출력
		System.out.println("행렬 출력 : ");
		for (int i=0; i<X.length; i++ ) {
			for(int j=0; j<X[0].length; j++) {
				if(X[i][j]>=10000)
				System.out.print(X[i][j] + " ");
				else if(X[i][j]>=1000)
				System.out.print(X[i][j] + "  ");
				else if(X[i][j]>=100)
				System.out.print(X[i][j] + "   ");
				else if(X[i][j]>=10)
				System.out.print(X[i][j] + "    ");
				else
				System.out.print(X[i][j] + "     ");
			}
			System.out.println();
		}
		System.out.println("======================구분선=========================");
	}
	
	static void getData(int[][]b) {
		// B,C 행렬 입력
		for (int i=0; i<B.length; i++ ) {
			for(int j=0; j<B[0].length; j++) {
				B[i][j] = rand.nextInt(100);
				C[i][j] = rand.nextInt(100);
			}
		}
		
		// E 행렬 입력
		for (int i=0; i<E.length; i++ ) {
			for(int j=0; j<E[0].length; j++) {
				E[i][j] = rand.nextInt(100);
			}
		}
		
	}
	
	static int[][] addMatrix(int[][]B, int[][]C){
		int m[][];
		int r = B.length;
		int c = B[0].length;
		
		m = new int[r][c];
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				m[i][j] = B[i][j] + C[i][j];
			}
		}
		
		return m;	
	}
	

	static int[][] multiplyMatrix(int B[][], int E[][]){
		int m[][] = new int[B.length][E[0].length];
		int num = 0;
		
		for(int i=0; i<B.length; i++) {
			for(int j=0; j<E[0].length; j++) {
				for(int k=0; k<B[0].length;k++) {
					num = num + B[i][k] * E[k][j]; 
				}
				m[i][j] = num;
				num = 0; // num 초기화
			}
		}
		return m;
	}
	
	static int[][] transposeMatrix(int B[][]){
		int m[][];

		int r = B.length;
		int c = B[0].length;
		
		m = new int[c][r];
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				m[j][i] = B[i][j];
			}
		}
		return m;	
	}
	public static void main(String[] args) {
	
	
		/*
		 * 난수 생성으로 초기화
		 * A[3][4] = B[3][4] + C[3][4]; D[3][5] = B[3][4] * E[4][5];
		 * F[4][3] = B[3][4]의 전치 행렬
		 */
	

		System.out.println("행렬 더하기: A[3][4] = B[3][4] + C[3][4]");
		getData(B);getData(C);getData(E);
		int A[][] = addMatrix(B, C);
		showMatrix(B);showMatrix(C);showMatrix(A);
		System.out.println("행렬 곱하기: D[3][5] = B[3][4] * E[4][5]");
		int D[][] = multiplyMatrix(B,E);
		showMatrix(B);showMatrix(E);showMatrix(D);
		System.out.println("행렬 전치: F[4][3] = B[3][4]의 전치 행렬");
		int F[][] = transposeMatrix(B);
		showMatrix(B);showMatrix(F);
	
	}
}
