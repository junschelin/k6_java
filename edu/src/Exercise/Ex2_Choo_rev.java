package Exercise;

import java.util.Scanner;

public class Ex2_Choo_rev {
	
	  public static void main(String[] args) {
	        System.out.print("10 ~ 100 사이 숫자를 입력하세요 : ");
	        Scanner sc = new Scanner(System.in); // Scanner 객체 생성
	        int num = sc.nextInt(); // 입력받을 숫자를 num에 저장
	        System.out.println();

	        // 입력된 숫자가 범위를 벗어나는 경우 재입력 받기
	        while (num < 10 || num > 100) {
	            System.out.println("다시 입력하세요");
	            System.out.print("10 ~ 100 사이 숫자를 입력하세요 : ");
	            num = sc.nextInt(); // 입력받을 숫자를 num에 저장
	            System.out.println();
	        }

	        // 숫자를 맞추는 메서드 호출
	        test(num);
	    }

	    static void test(int insertNum) {
	        int a = 2;
	        int b = 3;
	        int c = 5;
	        int[][] resultList = new int[10*10*10][3];
	        int count = 0; // 가능한 숫자 조합 개수를 세는 변수

			
	        // 모든 가능한 조합을 확인하여 숫자 맞추기
	        for (int i = 1; i < 11; i++) {
	            for (int j = 1; j < 11; j++) {
	                for (int k = 1; k < 11; k++) {
	                    int guess = insertNum - (a * i) - (b * j) - (c * k);
	                    // 맞춘 숫자가 0이면 조건에 맞는 숫자를 찾은 것이므로 출력하고 종료
	                    if (guess == 0) {
	                    	resultList[count][0] = i; 
	                    	resultList[count][1] = j; 
	                    	resultList[count][2] = k; 
	                        count++;
	                    }
	                }
	            }
	        }
	        // 출력
	        if (count == 0) {
	        	System.out.println("가능한 배열이 없습니다.");
	        } else {
	        System.out.println("찾은 가능한 모든 배열\n");
	        for(int i=0; i < count; i++) {
	        System.out.print("{" + resultList[i][0] + ", " + resultList[i][1] + ", " + resultList[i][2] + "} ");
	        }
	        System.out.println(": " + count + "개");
	        }
	    }
	
}
