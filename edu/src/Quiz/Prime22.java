package Quiz;

import java.util.Scanner;

public class Prime22 {
	public static void main(String[] args) {
		System.out.print("자리수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int s = (int)Math.pow(10.0, (double)(num-1));
		int e = (int)Math.pow(10.0, (double)(num))-1;
		
		for(int i = s; i <=e; i++) {
			boolean isPrime = true;
			
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime == true) {
				System.out.println(i);
			}
		}
	}
}
