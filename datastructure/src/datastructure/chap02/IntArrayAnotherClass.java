package datastructure.chap02;

import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;



public class IntArrayAnotherClass {

	public static void main(String[] args) {
		int []data = new int[10];
		
		inputData(data);
		showData(data);
		
		sortData(data);
		showData(data);
		
		reverse(data);//역순으로 재배치 - 정렬 아님 
		showData(data);

		reverseSort(data);//내림차순 정렬 
		showData(data);
		
		Arrays.sort(data);//자바 라이브러리(Array 클래스 sort Method)
		showData(data);
	}
	static void showData(int[]data) {
		for(int num : data) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	static void inputData(int []data) {//난수 생성해서 데이터 입력
		Random rand = new Random();
		for (int i=0; i<data.length; i++) {
			data[i] = rand.nextInt(100);
		}
	}
	static void swap(int[]arr, int ind1, int ind2) {//교재 67페이지
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	static void sortData(int []arr) { // 오름차순 정렬
		for (int i = 0; i< arr.length; i++) {
			for (int j = i+1; j<arr.length; j++) {
				if(arr[i]>arr[j]) { // 크기 비교해서 swap 사용   
					swap(arr, i, j);
				 }
			}
		}
	}
	
	static void reverse(int[] arr) {//배열 뒤집기
		for (int i = 0; i< arr.length; i++) {
			for (int j = i+1; j<arr.length; j++) {  
				swap(arr, i, j);
			}
		}
	}

	static void reverseSort(int []arr) {//교재 67페이지 (내림차순 정렬)
		for (int i = 0; i< arr.length; i++) {
			for (int j = i+1; j<arr.length; j++) {  
				if(arr[i]<arr[j])
					swap(arr, i, j);
			}
		}
	}

}
