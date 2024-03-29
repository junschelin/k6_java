package Quiz;

import java.util.Scanner;

public class GugudanTest {
	public static void main(String[] args) {
	
		Gugudan ggd = new Gugudan();
		
//		System.out.print("구구단 필요한 숫자 : ");
//		Scanner sc1 = new Scanner(System.in);
//		int num = sc1.nextInt();
//		ggd.print(num);
//		System.out.println("========================================================");
//		
//		ggd.printHorizontal();
		
		System.out.println("========================================================");
		System.out.print("구구단 단 나눌 열 : ");
		Scanner sc2 = new Scanner(System.in);
		int col = sc2.nextInt();
		ggd.printColumn(col);
		
		System.out.println("End");
	}
}

