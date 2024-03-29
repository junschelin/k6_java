package com.ruby.java.ch08.innerClass;

class Node3 {
	int data;
	Node3 link;
	public Node3(int data) {
		this.data = data; link = null;
	}
}

class LinkedList3 {
	Node3 first;
	void append(int data) {
		Node3 p = first, q = null;
		Node3 newNode = new Node3(data);
		if (p == null) {
			first = newNode;
			return;
		} else {
			while (p != null) {
				q = p;
				p = p.link;
			}
			q.link = newNode;
		}
	}
	void showList() {
		Node3 currentNode = first;

		while(currentNode != null) {
			System.out.print(" " + currentNode.data + " ");
			currentNode = currentNode.link;
		}
		
		System.out.println();
		
	}

	void insert(int data) {
		Node3 p = first, q = null;	
		
		if(data < first.data) {
			q = new Node3(data);
			first = q;
			q.link = p;
		}
		
		
		while(p!= null) {
			q = p;
			p = p.link;
			
			if(q.data < data && data < p.data) {
				Node3 temp = new Node3(data);
				q.link = temp;
				temp.link = p;
			} 
			
			if(p == null) 
			break;
			

		}

	}
	
}

public class Test_ch08_LinkedList {
	static int getList(int[]data) {
		int count = 0;
		int mid = data.length/2;
		for (int i = 0; i <= mid; i++) {
			data[i] = i * 5; count++;
		}
		return count;
	}
	
	static void showList(int[]data) {
		System.out.println();
		for (int i=0; i < data.length; i++)
			System.out.print(" " + i + " ");
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			if (data[i] < 10)
				System.out.print(" ");
			System.out.print(data[i]+ " ");
		}
	}
	
	static int insertList(int[] data, int count, int x) {
		int indx = 0;
		while (indx <= count) {
			if (x < data[indx]) {
				while(indx <= count) { //count 사용
					int temp = data[indx];
					data[indx] = x;
					x = temp;
					indx ++;
				}
				//break;
			}
			else {
				indx ++;
			}
		}
		//count ++ ;
		return ++count;
	}
	
	public static void main(String[] args) {
		int[]list = new int[10];
		int count = 0;
		System.out.println("배열로 리스트::");
		count = getList(list);
		showList(list);
		System.out.println("\n\n3 Insert");
		count = insertList(list, count, 3);
		showList(list);
		System.out.println("\n\n7 Insert");
		count = insertList(list, count, 7);
		showList(list);
		
		System.out.println();
		
		System.out.println("\nLinked List\n");
		LinkedList3 ll = new LinkedList3();
		ll.append(5);ll.append(10);ll.append(15);ll.append(20);ll.append(25);
		ll.showList();
		
		System.out.println("\nLinked List (Insert)\n");
		ll.insert(3);ll.showList();
		ll.insert(7);ll.showList();
		ll.insert(16);ll.showList();
		ll.insert(21);ll.showList();
		ll.insert(2);ll.showList();
		
	}

}

