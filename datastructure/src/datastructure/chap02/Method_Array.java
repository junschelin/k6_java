package datastructure.chap02;

//메소드에 배열 전달 실습부터
//실습 설명한다 
//매개변수로 배열 전달
import java.util.Random;
import java.util.Scanner;

public class Method_Array {

	public static void main(String[] args) {
		System.out.print("찾을 수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int findNum = sc.nextInt();
		
		int []data = new int[10];
		inputData(data);
		showData(data);
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, findNum);
		System.out.println("찾는 값 = " + findNum + ", 존재여부 = " + existValue);
	}
	static void showData(int[]data) {
		for (int num: data) {
			System.out.print(num+" ");
		}
	}
	public static void inputData(int []data) {//교재 63 - 난수의 생성
		Random rand = new Random();
		for (int i=0; i<data.length; i++) {
			data[i] = 1 + rand.nextInt(100); // 1에서 10사이 난수
		}
	}
	static int findMax(int []items) {
		int maxNum = 0;
		for (int num : items) {
			if(num >= maxNum)
				maxNum = num;
		}
		return maxNum;

	}
	static boolean findValue(int []items, int value) {
		//items[]에 value 값이 있는지를 찾는 알고리즘 구현
		boolean isTrue = false;
		for (int num : items) {
			if (value == num) {
				isTrue = true;
				break;
			}	
		}
		return isTrue;
	}
}
