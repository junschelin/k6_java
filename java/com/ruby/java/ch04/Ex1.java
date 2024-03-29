package com.ruby.java.ch04;

import java.util.Random;

public class Ex1 {

	public static void main(String[] args) {
		
		int A[][] = new int[3][4]; //난수 입력
		int B[][] = new int[4][5]; //난수 입력
		int C[][] = new int[3][5]; 
		int D[][] = new int[3][4]; //난수 입력
		int E[][] = new int[3][4]; 
		int F[][] = new int[4][4]; 
	
		Random rand = new Random();
		
		System.out.println("행렬 A : ");
		for(int i=0 ; i<A.length; i++) {
			for(int j = 0; j<A[i].length; j++) {
				A[i][j] = rand.nextInt(10);
				System.out.print(A[i][j]+"\t");
			}
			System.out.println("\n");
		}
		
		System.out.println("행렬 B : ");
		for(int i=0 ; i<B.length; i++) {
			for(int j = 0; j<B[i].length; j++) {
				B[i][j] = rand.nextInt(10);
				System.out.print(B[i][j]+"\t");
				}
			System.out.println("\n");
		}
		
		System.out.println("행렬 D : ");
		for(int i=0 ; i<A.length; i++) {
			for(int j = 0; j<D[i].length; j++) {
				D[i][j] = rand.nextInt(10);
				System.out.print(D[i][j]+"\t");
			}
			System.out.println("\n");
		}
		
		
	// 1번. C = A * B; (행렬 곱)
		int num = 0;
		System.out.println("Q1. 행렬 C : A x B");
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<B[i].length; j++) {
				for(int k=0; k<A[i].length; k++) {
					num = num + A[i][k] * B[k][j];
				}
				C[i][j] = num;	
				num = 0;
				System.out.print(C[i][j]+"\t");
			}
			System.out.println("\n");
		}
			
	// E = A + D; (행렬 합)

		System.out.println("Q2. 행렬 E : A + D");
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				D[i][j] = A[i][j] + D[i][j];	
				System.out.print(D[i][j]+"\t");
			}
			System.out.println("\n");
		}	
		
	// F = A의 전치 행렬
		
		System.out.println("Q3. 행렬 F : Transpose of A Matrix");
		for(int i=0;i<A[0].length; i++) {
			for(int j=0; j<A.length; j++) {
				F[i][j] = A[j][i];	
				System.out.print(F[i][j]+"\t");
			}
			System.out.println("\n");
		}		
		
	}
}
