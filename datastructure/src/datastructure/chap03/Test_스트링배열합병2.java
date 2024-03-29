package datastructure.chap03;

/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;
import java.util.List;

// 1. s1 오름차순으로 정렬
// 2. s2 오름차순으로 정렬
// 3. s1 : p, s2 : q로 지정해서 p요소 하나씩 가면서 q랑 비교해서 p가 더 빠르면 p 쭉 넣고 그 q가 더 크면 q 다음 인덱스로 넘어감
// (방법은 while 루프나 for 루프 둘 중 하나로 할 수 있을 것 같음)

public class Test_스트링배열합병2 {
    static void showList(String topic, String [] list) {
    	System.out.print(topic);
    	for (String item : list){
    		System.out.print(item + " ");
    	}
    	System.out.println();
    }
    static String[] mergeList(String[]s1, String[] s2) {
    	int i = 0;
    	String[] s3 = new String[10];
    	for(String item_1 : s1) {
    		s3[i++] = item_1;
    	}
    	for(String item_2 : s2) {
    		s3[i++] = item_2;
    	}
    	
    	return s3;
    }
    public static void main(String[] args) {
	String[] s1 = { "홍길동", "강감찬", "을지문덕", "계백", "김유신" }; 
	String[] s2 = {"독도", "울릉도", "한산도", "영도", "우도"}; 
	Arrays.sort(s1);
	Arrays.sort(s2);
	
	showList("s1배열 = ", s1);
	showList("s2배열 = ", s2);

	String[] s3 = mergeList(s1,s2);
	showList("스트링 배열 s3 = s1 + s2:: ", s3);
}
}
