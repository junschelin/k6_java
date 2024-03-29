package Quiz;

import java.util.Scanner;

////소수찾기(PrimeNumber3)
////• 정수의 자릿수를 입력받아서 아래와 같은 형태의 소수를 찾아서 출력하는 프로그램을 작성해 보세요.
////• 예
////• 입력자릿수: 4 (1000 ~ 9999)
////• 7331 ➔ 7, 73, 733, 7331 모두 소수

public class Prime3 {
	public static void main(String[] args){
		System.out.print("자리수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
        int start = (int) Math.pow(10, num - 1);
        int end = (int) Math.pow(10, num) - 1;
		
		for (int i=start; i<=end; i++){
			int isPrime = 1;
			for(int j=num-1; j>=0; j--){
				int currentNum = i/tenPower(j); //10의 j승
				int cnt = 0;
				for(int k=1; k<=currentNum; k++){
					if( currentNum % k == 0 ){
						cnt ++;
					}
				}
				if (cnt == 2){
					isPrime *= 1;
				}
                else {
                	isPrime *= 0;
                }
				if (j==0 && isPrime ==1){
					System.out.println(i);
				}
				
			}
		}
	}
	public static int tenPower(int power){
		int result = (int) Math.pow(10, power);
        return result;
        }
}
