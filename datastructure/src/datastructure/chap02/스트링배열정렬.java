package datastructure.chap02;

public class 스트링배열정렬 {
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon","pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData(data);
		sortData(data);
		showData(data);
	}
	static void showData(String[]arr) {
		for(String name : arr)
			System.out.print(name + " | ");
		System.out.println();
	}

	static void swap(String[]arr, int ind1, int ind2) {
		//구현 필요
		String temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	static void sortData(String []arr) {
		for (int i = 0; i < arr.length; i++ ){
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j])>0) {//compareTo() 사용하는 예제
					swap(arr,i,j);
				}
			}
		}
	}
}