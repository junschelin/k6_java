package Quiz;

import java.util.Arrays;
import java.util.Scanner;

public class Prime3_new {

	static int tenPower(int number) {
		return (int) Math.pow(10, number);
	}
	
	static void printNum(int number[]) {
		for (int i = number.length -1 ; i>=0; i--) {
			System.out.print(number[i]);
		}
	}
	
	static int[] splitNum(int number[], int start) {

		int temp = start;
        for (int i = number.length - 1; i>=0; i--) {
        	number[i] = temp / tenPower(i);
        	temp %= tenPower(i);
        }
        return number;
	}
	
    // 소수 판별 메소드
	static int primeTest(int[]number) {
		int isPrime = 1;
		for(int i = 0; i < number.length; i++) {
			if(number[i] >= 0 && number[i] <=2 ) {
				isPrime *= 0;
				break;
			}
			for(int j = 2; j < number[i]; j++) {
				if(number[i] % j == 0) {
					isPrime *= 0;
					break;
				}
			}
		}
		return isPrime;
	}
    
	
    public static void main(String[] args) {
        System.out.print("자리수를 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int start = (int) Math.pow(10, num - 1);
        int end = (int) Math.pow(10, num) - 1;

        System.out.println(start + ", "+ end);
    
        
        // 각 자리 숫자 뽑아내기
        int number[] = new int[num];
     
        for (int i = start; i <= end; i++) {
        	int lst[] = splitNum(number, i);
        	if (primeTest(lst) == 1) {
        		printNum(lst);
        		System.out.println();
        	}
        }
    } 
}

