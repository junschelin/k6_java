package Assignment;

import java.util.Random;

/*
 * 클래스 메소드 구현 실습 목적
 */
class Matrix {
	int rows;
	int cols;
	int[]data;
	public Matrix(int rows, int cols) {
		this.rows = rows; this.cols = cols;
		data = new int[rows * cols];
	}
	
	Random rand = new Random();
	
	
	// 난수로 입력
	void getData() {
		for (int i=0; i<rows*cols; i++) {
				data[i] = rand.nextInt(100);
			}
	}
	
	Matrix addMatrix(Matrix c) {//A = B.addMatrix(C);
		Matrix m = new Matrix(this.rows, this.cols);
		for (int i=0; i<rows*cols; i++) {
			m.data[i] = this.data[i] + c.data[i];
		}
		return m;
	}
	
	Matrix multiplyMatrix(Matrix e) { //D = B.multiplyMatrix(E);
		int sum = 0;
		Matrix m = new Matrix(this.rows, e.cols);
		for (int i=0; i<this.rows; i++) {
			for (int j=0; j<e.cols; j++) {
				for (int k=0; k<e.rows; k++) {
					sum = sum + this.data[i+k] * e.data[j+k*e.cols];
				}
				m.data[i*this.rows + j]=sum;
				sum = 0;
			}
		}
		return m;	
	}
	Matrix transposeMatrix() {
		Matrix m = new Matrix(this.cols, this.rows);
		return m;
	}
	void showMatrix(String str) {
		System.out.println(str);
		//2차원 배열 모양으로 출력하는 코드 작성
		
		for(int i = 0; i<rows*cols; i++) {
			if(i % cols == 0) 
				System.out.println();
			System.out.print(data[i] + " ");	
			
//			if(data[i]>=10000)
//				System.out.print(data[i] + " ");
//			if(data[i]>=1000)
//				System.out.print(data[i] + "  ");
//			if(data[i]>=100)
//				System.out.print(data[i] + "   ");
//			if(data[i]>=10)
//				System.out.print(data[i] + "    ");
//			else
//				System.out.print(data[i] + "     ");
		}
		System.out.println("\n");
	}
}
public class Test_Ch06_Matrix_Class {

	public static void main(String[] args) {
		/*
		 * 난수 생성으로 초기화
		 * A[3][4] = B[3][4] + C[3][4]; D[3][5] = B[3][4] * E[4][5];
		 * F[4][3] = B[3][4]의 전치 행렬
		 */
		Matrix B = new Matrix(3,4);
		Matrix C = new Matrix(3,4);
		Matrix A, D, F;
		Matrix E = new Matrix(4,5);

		System.out.println("행렬 더하기: A[3][4] = B[3][4] + C[3][4]");
		B.getData();C.getData();E.getData();
		
		A = B.addMatrix(C);
		B.showMatrix("B[3][4]");C.showMatrix("C[3][4]");A.showMatrix("A[3][4]");
		
		System.out.println("행렬 곱하기: D[3][5] = B[3][4] * E[4][5]");
		D = B.multiplyMatrix(E);
		B.showMatrix("B[3][4]");E.showMatrix("E[4][5]");D.showMatrix("D[3][5]");
		
		System.out.println("행렬 전치: F[4][3] = B[3][4]의 전치 행렬");
		F = B.transposeMatrix();
		B.showMatrix("B[3][4]"); F.showMatrix("F[4][3]");

	}

}
