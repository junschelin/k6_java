package datastructure.chap02;

import java.util.Arrays;
//구글링 : comparator, comparable 차이가 무엇인지 사용 예 파악하고 활용해보기
// comparator : '같다 / 아니다'의 결과 값을 boolean으로 출력
// comparable : 크기 비교의 개념으로 크면 1 작으면 -1 같으면 0 출력
//5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;
	
	PhyscData(String name, int height, double vision){
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	@Override
	public String toString() { //껍데기만 주고 내용을 채우라
		return "[" + name + ", " + height + ", " + vision + "]";
	}
	
	@Override
	public int compareTo(PhyscData p) {
		if (this.name.compareTo(p.name) != 0) {
			return this.name.compareTo(p.name);
		} 
		else {
			return 0;			
		}
	}
	
//	public int equals(PhyscData p) {
//		if (p == p.height)
//			return 1;
//		else
//			return 0;
//	}
}
public class 객체배열정렬 {
	static void swap(PhyscData arr[], int ind1, int ind2) {
		PhyscData temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	static void sortData(PhyscData []arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = i+1; j<arr.length; j++) {
				if(arr[i].compareTo(arr[j]) > 0) {
					swap(arr, i, j);
				}
			}
		}
	}
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};
		showData(data);
		System.out.println("=============sort===============");
		sortData(data);
//		Arrays.sort(null, null);//comparator가 필요하다 
		showData(data);
	}
	static void showData(PhyscData[]arr) {
		for(PhyscData item : arr) {
			System.out.println(item);
		}
		
	}

}
