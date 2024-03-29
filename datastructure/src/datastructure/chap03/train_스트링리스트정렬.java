package datastructure.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class train_스트링리스트정렬 {

	    public static String[] removeElement1(String[] arr, String item) {
	    	// 현재 배열에서 중복 제거하려면 코드가 길어진다 (지우고 데이터 하나씩 다 땡겨야함)
	    	// 배열을 리스트 변환 -> list.remove();
	    	// 삭제된 리스트를 배열로 변환하여 리턴 (list.toArray(String[]::new); //String[]::new -> 람다식(함수형 인터페이스)
	    }
	    
	    static void getList(List<String> list) {
			list.add("서울");	list.add("북경");
			list.add("상해");	list.add("서울");
			list.add("도쿄");	list.add("뉴욕");


			list.add("런던");	list.add("로마");
			list.add("방콕");	list.add("북경");
			list.add("도쿄");	list.add("서울");

			list.add(1, "LA");
	    }
	    static void showList(String topic, List<String> list) {
	    	System.out.println(topic);
	    	System.out.print(list);
	    }
	    static void sortList(List<String> list) {
	    	//방법 1 : 내가 구현
	    	//방법 2 : list.sort(null)
	    	//방법 3 : 리스트를 스트링 배열로 변환
	    	
	    	for(int i=0; i<list.size(); i++) {
	    		for(int j=i+1; j<list.size(); j++) {
	    			if(list.get(i).compareTo(list.get(j))>0) {
	    				swap(list, i, j);
	    			}
	    		}
	    	}
	    }
	    static void swap(List<String> list, int i, int j) {
	    	String temp = list.get(i);
	    	list.set(i, list.get(j));
	    	list.set(j, temp);
	    }
	    
	    static String[] removeDuplicateList(List<String> list) {
		    String cities[] = new String[0];
		    cities = list.toArray(cities); // list.toArray : list를 배열로 변경 (size가 부족하면 공간 할당까지 자동으로)
		    // list를 배열 cities[]로 변환해서 중복제거 한번 해보고
		    // arrayList로 중복제거 한번 해보고, 2번 해보자.
		    
		    int idx = 0;
		    boolean isSame = false;
		    String new_cities[] = new String[list.size()];
		    for (int i=0; i<cities.length; i++) {
		    	for(int j=i+1; j<cities.length; j++) {
	    			if(cities[i].compareTo(cities[j]) == 0) {
	    				isSame = true;
	    			}
	    		}
		    	if (isSame){
		    		new_cities[idx]=cities[i];
		    		idx ++;
		    	}
		    }
		    
		    return cities;
	    }
		public static void main(String[] args) {
			ArrayList<String> list = new ArrayList<>();
			getList(list);
			showList("입력후", list);
			//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩

//		    Collections.sort(list); //Collections의 sort 메서드도 한번 써보자!

//배열의 정렬
			sortList(list);
		    System.out.println();
		    showList("정렬후", list);
// 배열에서 중복제거
		    System.out.println();
		    System.out.println("중복제거::");
		  
		    String[] cities = removeDuplicateList(list);
	        ArrayList<String> lst = new ArrayList<>(Arrays.asList(cities));
		    showList("중복제거후", lst);
		}
	}

