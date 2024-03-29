//추 2, 3, 5g 활용하여 입력받은 숫자 맞추기

package Exercise;

import java.util.Scanner;

public class Ex2_Choo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("10 ~ 100 사이 숫자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in); // Scanner 객체 생성
		int num = sc.nextInt(); // 입력받을 숫자를 num에 저장
		System.out.println();
		
		while (num<10 || num>100) {
			System.out.println("다시 입력하세요");
			System.out.print("10 ~ 100 사이 숫자를 입력하세요 : ");
			sc = new Scanner(System.in); // Scanner 객체 생성
			num = sc.nextInt(); // 입력받을 숫자를 num에 저장
			System.out.println();
		}
		test(num);

	}

	static void test(int number) {
		
		int a = 2;
		int b = 3;
		int c = 5;
		
		int cnt = 0;
		
		int d[][] = new int[10*10*10][3];
		
		//한번 씩 미리 사용

		for(int i=1;i<11;i++) {
			for(int j=1;j<11;j++) {
				for(int k=1;k<11;k++) {
					if (number == (a*i) + (b*j) + (c*k)) {
						d[cnt][0]=i;
						d[cnt][1]=j;
						d[cnt][2]=k;
						cnt++;
					}
				}
			}
		}
		if (cnt == 0) {
			System.out.println("구할 수 없는 수입니다.");
		} 
		else {
			System.out.println("찾은 가능한 모든 배열 : ");
		for (int i = 0; i < cnt ; i++) {
			System.out.print("{" + d[i][0] + "," + d[i][1] + "," + d[i][2] + "} ");
		}
		System.out.println(" / 개수 : " + cnt);
		}
	
	}
}
