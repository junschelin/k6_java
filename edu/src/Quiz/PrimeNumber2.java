package Quiz;

import java.util.Scanner;

public class PrimeNumber2 {
	public static void main(String[] args) {
		System.out.print("자리수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int s = (int)Math.pow(10.0, (double)(num-1));
		int e = (int)Math.pow(10.0, (double)(num))-1;
		
		for(int i = s; i <=e; i++) {
			int nowNum = i;
			int count = 0;
			
			for(int j = 1; j<=nowNum; j++) {
				if(i % j == 0) {
					count ++;
				}
			}
			
			if(count == 2) {
				System.out.println(i + "는 소수");
			}
		}
	}
}