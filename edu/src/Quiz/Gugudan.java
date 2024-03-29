package Quiz;



public class Gugudan {
	
	public void printHorizontal() {
		
		for (int i=1; i<10; i++) {
			for (int j=2; j<10; j++) {
				System.out.print(j + " * " + i + " = " + j*i +"\t");
			}
			System.out.println();
		}
	}

	public void printColumn(int col) {
		int c;
		if (8 % col != 0)
			c = col+1;
		else
			c = 8/col;
		
		for (int i=0; i<c; i++) { //바깥 루프 어케하노
			for (int j=1; j<10; j++) {
				for (int k = 2 + i*col; k < 2 + (i+1)*col; k++) {
					if (k > 9)
						break;
					
					System.out.print(k + " * " + j + " = " + k*j +"\t");
				}
				if (2 + i*col > 9)
					break;
				System.out.println();
			}
			if (2 + i*col > 9)
				break;
			System.out.println();
		}
	}

	
	//GPT 코드
	
//	public void printColumn(int col) {
//	    for (int i = 1; i <= 9; i++) { // 각 행
//	        for (int j = 2; j <= 9; j += col) { // 구구단 열
//	            for (int k = j; k < j + col && k <= 9; k++) { // 한 행에 col 개의 구구단 출력
//	                System.out.printf("%d * %d = %d\t", k, i, k * i);
//	            }
//	            System.out.println();
//	        }
//	        System.out.println();
//	    }
//	}


	public void print(int i) {
	
		for (int k=1; k<10; k++) {
			System.out.println(i + " * " + k + " = " + i*k);
		}
	}
	
// 1단 구구단 출력 시작

// 2*1=2

// 2*2=4

// 2*3=6

// ...

// 2*9=18

//

// i단 구구단 출력 끝

}