package datastructure.chap10;

import java.util.Scanner;

//체인법에 의한 해시
//--- 해시를 구성하는 노드 ---//

class Node {
    int key;                 // 키값
    Node next;        // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)
    
    public Node(int k) {
	    this.key = k;
	    this.next = null;
    }
    
}
class SimpleChainHash {
 private int    size;              // 해시 테이블의 크기
 private Node[] table;        // 해시 테이블

 	 // 생성자
	 public SimpleChainHash(int size) {
		// TODO Auto-generated constructor stub
		 this.size = size;
		 this.table = new Node[size];
	}

	//--- 키값이 key인 요소를 검색(데이터를 반환) ---//
	 public int search(int key) {
		 int indx = key % size;
		 
		 if (table[indx] == null)
			 return 0;
		 
		 else {
			 Node p = table[indx];
			 Node q = null;
			 
			 while(p != null) {
				 q = p;
				 if(q.key == key)
					 return 1;
				 else
					 p = p.next;
			 }
			 
			 if(q.key == key)
				 return 1;
			 else
				 return 0;
		 }
		 
	 }
	
	 
	 //--- 키값이 key인 데이터를 data의 요소로 추가 ---//
	 public int add(int key) {
		 //hash value : 11으로 나눈 나머지
		 
		 Node newNode = new Node(key);
		 int indx = key % size;
		 Node p = table[indx];
		 Node q = null;
		 
		 if(p == null) {
			 table[indx] = newNode;
			 return 0;
		 }
		 
		 else {
			 while (p!= null) {
				 if (p.key == key) {
					 System.out.println("중복");
					 return 1;
				 }
				 else if (key > p.key ) {
					 q = p;
					 p = p.next;
				 }
				 // p.key > key
				 else {
					 if(q == null) {
						 table[indx] = newNode;
						 newNode.next = p;
					 }
					 else {
						 q.next = newNode;
						 newNode.next = p;
					 }
					 return 0;
				 }
			 }
			 q.next = newNode;
			 return 0;
		 }
	 }
	
	 //--- 키값이 key인 요소를 삭제 ---//
	 public int delete(int key) {
		int indx = key % size;
		 
		if (table[indx] == null)
			 return 0;
		 
		else {
			 Node p = table[indx];
			 Node q = null;
			 
			 while(p != null) {
				 if (q == null)
					 if(p.key == key) {
						 if(p.next == null) 							 
							 table[indx] = null;
						 else 
							 table[indx] = p.next;
						 
						 return 1;
					 }
				 
					 else {
						q = p;
						p = p.next;
					 }
				 
				 else {		 
					 if(p.key == key) {						 
						 q.next = p.next;
						 return 1;
					 }
					 else
						 q = p;
						 p = p.next;
				 }
			 }
			 
			 return 0;
		 }
	 }
	
	 //--- 해시 테이블을 덤프(dump) ---//
	 public void dump() {
		 for (int i = 0; i<size; i++) {
			 Node currentLink = null;
			 Node nextLink = this.table[i];
				 
			 while(nextLink != null) {
				 currentLink = nextLink;
				 System.out.print(currentLink.key + "  ");
				 nextLink = nextLink.next;
			 }
		 }
		 System.out.println();
	 }
}

public class Test_실습10_1정수체인해시 {

	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), Show("출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}
		// --- 메뉴 선택 ---//
		static Menu SelectMenu() {
			Scanner sc = new Scanner(System.in);
			int key;
			do {
				for (Menu m : Menu.values()) {
					System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
					if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
						System.out.println();
				}
				System.out.print(" : ");
				key = sc.nextInt();
			} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
			return Menu.MenuAt(key);
		}


//체인법에 의한 해시 사용 예
 public static void main(String[] args) {
	 	Menu menu;
	 	// 11 나누기의 나머지를 해시 값으로 저장
		SimpleChainHash hash = new SimpleChainHash(11);
		Scanner stdIn = new Scanner(System.in);
		int select = 0, result = 0, val = 0;
		final int count = 15;
		do {
			switch (menu = SelectMenu()) {
			case Add:

				int[] input = new int[count];
				for (int ix = 0; ix < count; ix++) {
					double d = Math.random();
					input[ix] = (int) (d * 30);
					System.out.print(input[ix] + " ");
				}
				System.out.println();
				
				for (int i = 0; i < count; i++) {
					if ((hash.add(input[i])) == 0)
						System.out.println("Insert Duplicated data");
				}
				break;
				
			case Delete:
				// Delete
				System.out.println("Search Value:: ");
				val = stdIn.nextInt();
				result = hash.delete(val);
				if (result != 0)
					System.out.println(val + " 삭제 완료");
				else
					System.out.println(" 검색 데이터가 없음");
				System.out.println();
				break;
			case Search:
				System.out.println("Search Value:: ");
				val = stdIn.nextInt();
				result = hash.search(val);
				if (result != 0)
					System.out.println(" 검색 데이터가 존재한다");
				else
					System.out.println(" 검색 데이터가 없음");
				System.out.println();
				break;

			case Show:
				hash.dump();
			break;
		}
	} while (menu != Menu.Exit);

	}
}
