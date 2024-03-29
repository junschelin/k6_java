package Exercise;

public class Ex3_Matrix{
	static int[][] mA = { //3 x 4
		{1, 2, 3, 4},
		{5, 6, 7, 8},
		{9, 10, 11, 12}
	};
		
	static int[][] mB = { //4 x 3
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9},
		{10, 11, 12}
	};
	
	static int[][] mC = new int[3][3];
	
	static int sum = 0;
	
	public static void main(String[] args) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 4; k++) {
					sum = sum + mA[i][k] * mB[k][j];
				}
				mC[i][j] = sum;
				sum = 0;
			}
		}
		
		System.out.println("mA x mB 결과 mC 출력");
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(mC[i][j]>999)
					System.out.print(mC[i][j] + " ");
				else if(mC[i][j]>99)
					System.out.print(mC[i][j] + "  ");
				else if(mC[i][j]>9)
					System.out.print(mC[i][j] + "   ");
			}
			System.out.println();
		}
		
	}
	
}