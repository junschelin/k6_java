//추 2, 3, 5g 활용하여 입력받은 숫자 맞추기

package Exercise;

import java.util.Scanner;

public class ch5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("10 ~ 100 사이 숫자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in); // Scanner 객체 생성
		int num = sc.nextInt(); // 입력받을 숫자를 num에 저장
		System.out.println();
		
		/*
		if (num<10 || num>100) {
			num = 0;
			System.out.println("다시 입력하세요");
			System.out.print("10 ~ 100 사이 숫자를 입력하세요 : ");
			sc = new Scanner(System.in); // Scanner 객체 생성
			num = sc.nextInt(); // 입력받을 숫자를 num에 저장
			System.out.println();
		}*/
		
	}

	static int[] test(int number) {
		
		int a = 2;
		int b = 3;
		int c = 5;
		
		int d[][];
		
		//한번 씩 미리 사용
		int numberAfterOnceUsage = number - (a + b + c);
		
		for(int i=0;i<10;i++) {
			number = numberAfterOnceUsage - (a*i) ;
			for(int j=0;j<10;j++) {
				number = numberAfterOnceUsage - (b*j) ;
				for(int k=0;k<10;k++) {
					number = numberAfterOnceUsage - (c*k) ;
					if (number == 0) {
						d[0]=i;
						d[1]=j;
						d[2]=k;
					}
					
				}
			}
		}
		
		return d;
	}
	
}
