package datastructure.chap03;

//3장 객체 배열 정렬 - binary search
/*
* Comparator를 사용하는 방법
* MyComparator implements Comparator<>
* MyComparator myComparator = new MyComparator();
* Arrays.sort(array, myComparator);
* Collections.sort(list, myComparator);
*/

import java.util.Arrays;
import java.util.Comparator;

class Fruit4 {
	String name;
	int price;
	String expire;

	Fruit4(String n, int p, String e) {
		this.name = n;
		this.price = p;
		this.expire = e;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getExpire() {
		return expire;
	}
}
//교재 123~129 페이지 참조하여 구현 (정렬)
// compare(f1, f2) : f1이 f2 보다 크면 양수, f1이 f2보다 작으면 음수, f이 f2와 같으면 0 반환

class FruitNameComparator2 implements Comparator<Fruit4> {
	public int compare(Fruit4 f1, Fruit4 f2) {
		return f1.price - f2.price;

	}
}

public class 객체배열이진탐색 {

	private static void sortData(Fruit4[] arr, Comparator<Fruit4> cc_price) {

	}

	static void swap(Fruit4[] arr, int ind1, int ind2) {
		Fruit4 temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}

	static void sortData(Fruit4[] arr, FruitNameComparator2 cc) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++)
				if (cc.compare(arr[i], arr[j]) > 0)
					swap(arr, i, j);
		}
	}

	static void showData(String s, Fruit4[] arr) {
		System.out.println(s);
		for (Fruit4 obj : arr) {
			System.out.print(obj.getName() + ", " + obj.getPrice() + ", " + obj.getExpire() + "\n");
		}
	}

	static void reverse(Fruit4[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				Fruit4 temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	
	static int binarySearch(Fruit4 [] arr, Fruit4 data, Comparator<Fruit4> c) {
		int s = 0, e = arr.length;
		int mid;
		while(true) {
			mid = (s+e) / 2;
			if (c.compare(data, arr[mid])==0) {
				break;
			}
			else if(c.compare(data, arr[mid])>0) {
				s = mid+1;
			}
			else {
				e = mid-1;
			}
			if( s>=e ) {
				break;
			}
		}
		return mid;

	}

	public static void main(String[] args) {

		Fruit4[] arr = { new Fruit4("사과", 200, "2023-5-8"), new Fruit4("감", 500, "2023-6-8"),
				new Fruit4("대추", 200, "2023-7-8"), new Fruit4("복숭아", 50, "2023-5-18"),
				new Fruit4("수박", 880, "2023-5-28"), new Fruit4("산딸기", 10, "2023-9-8") };

		System.out.println("===== 정렬전 객체 배열 =====");
		showData("정렬전 객체", arr);

		FruitNameComparator2 cc = new FruitNameComparator2();
		System.out.println("\n===== comparator cc 객체를 사용 =====\n");
		Arrays.sort(arr, cc); //Arrays.sort의 정렬 원리가 sortData와 동일
		showData("Arrays.sort(arr, cc) 정렬 후\n", arr);
		
		System.out.println("\n===== 역순 재배치 =====\n");
		reverse(arr);
		showData("역순 재배치 후\n", arr);
		
		System.out.println("\n===== sortData cc 재배치 =====\n");
		sortData(arr, cc);
		showData("sortData(arr,cc) 실행후\n", arr);

		
		// 람다식은 익명클래스 + 익명 객체이다
		System.out.println("\n===== 람다식 변수 cc_price2을 사용한 Arrays.sort(arr, cc) 정렬 후 =====\n");
		Comparator<Fruit4> cc_price2 = (a, b) -> a.getPrice() - b.getPrice();
		Arrays.sort(arr, cc_price2); // 람다식으로 만들어진 객체를 사용
		showData("람다식 변수 cc_price2을 사용한 Arrays.sort(arr, cc) 정렬 후", arr);
		
		System.out.println("\n===== 람다식: (a, b) -> a.getPrice() - b.getPrice()을 사용한 Arrays.sort(arr, cc) 정렬 후 =====\n");
		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit4에 compareTo()가 있어도 람다식 우선 적용
		showData("람다식: (a, b) -> a.getPrice() - b.getPrice()을 사용한 Arrays.sort(arr, cc) 정렬 후", arr);

		System.out.println("\n===== 익명클래스 객체로 정렬(이름)후 객체 배열 =====\n");
		Arrays.sort(arr, new Comparator<Fruit4>() {
			@Override
			public int compare(Fruit4 a1, Fruit4 a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		

		System.out.println("\ncomparator 정렬(이름)후 객체 배열: ");
		Comparator<Fruit4> cc_name = new Comparator<Fruit4>() {// 익명클래스 사용
			@Override
			public int compare(Fruit4 f1, Fruit4 f2) {
				// TODO Auto-generated method stub
				return (f1.name.compareTo(f2.name));
			}
		};
		Arrays.sort(arr, cc_name);
		showData("comparator 객체를 사용한 정렬:", arr);
		
		System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
		Comparator<Fruit4> cc_price = new Comparator<Fruit4>() {
			@Override
			public int compare(Fruit4 f1, Fruit4 f2) {
				return f1.getPrice() - f2.getPrice();
			}// 익명클래스 사용
		};
		Arrays.sort(arr, cc_price);
		showData("comparator 객체를 사용한 정렬:", arr);

		Fruit4 newFruit4 = new Fruit4("수박", 880, "2023-5-18");
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		

		
		int result3Index = Arrays.binarySearch(arr, newFruit4, cc_name);
		System.out.println("\nArrays.binarySearch([수박,880,2023-5-18]) 조회결과::" + result3Index);
		
		result3Index = binarySearch(arr, newFruit4, cc_name);
		System.out.println("\nbinarySearch([수박,880,2023-5-18]) 조회결과::" + result3Index);

		sortData(arr, cc_price);
		System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
		showData("comparator를 사용한 정렬후:", arr);
		
		result3Index = Arrays.binarySearch(arr, newFruit4, cc_price);
		System.out.println("\nArrays.binarySearch([수박,880,2023-5-18]) 조회결과::" + result3Index);
		
		result3Index = binarySearch(arr, newFruit4, cc_price);
		System.out.println("\nbinarySearch() 조회결과::" + result3Index);
		

	}

}
