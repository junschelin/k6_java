package com.ruby.java.ch08.innerClass;

public class MyLinkedList {

	private Node head = null;
	
	
	private class Node{
		private String data;
		private Node link;

		public Node(String data) {
			// 생성자는 필드가 2개 이므로 heap에 필드 공간 2개를 할당
			this.data = data; link = null;
		}
	}
	
	public MyLinkedList(Node head) {
		this.head=head;
	}
	
	public void add(String data) {
		Node newNode = new Node(data);
		if(head==null) 
			head = newNode;
		else {
			Node next = head;
			while(next.link != null) {
				next = next.link;
			}
			next.link = newNode;
		} 
	}
	
	public void print() {
		if(head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		} else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next = head;
			while(next != null) {
				System.out.println(next.data);
				next = next.link;
			}
		}
	}
}
