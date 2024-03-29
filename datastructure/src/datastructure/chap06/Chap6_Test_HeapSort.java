package datastructure.chap06;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // current size of MaxHeap
	private int MaxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {
		this.heap = new int [sz];
		n = 0;
		MaxSize = sz;
	}
	
	// 출력
	public void display() {
		Chap6_Test_HeapSort.showData(heap);
	}
	@Override
	public void Insert(int x) {
		int i;
		if (n == MaxSize) {HeapFull(); return;}
		for (i = n; i<=n+1; i++) {
			if (i == 1) {
				break;				
			}
			if (heap[x] <= heap[i/2]) {
				break;
			}
			heap[i] = heap[i/2];
			i /= 2;
		}
		heap[i] = x;
	}
	@Override
	public int DeleteMax() {
		if (n == 0) {
			HeapEmpty(); return 0;			
		}
		
		return 1; 
	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}
public class Chap6_Test_HeapSort {
	 static void showData(int[] d) {
	     for (int i = 0; i < d.length; i++)
	         System.out.print(d[i] + " ");
	     System.out.println();
	 }
	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 10;
	    int[] x = new int[count+1];
	    int []sorted = new int[count];

		do {
			System.out.print("Max Tree. Select: 1 insert, 2 display, 3 내림차순_sort(delete), 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:
				System.out.println("난수 입력");
				int input = rnd.nextInt(100); //0에서 99까지 난수 생성
				heap.Insert(input);
				heap.display();
				break;
			case 2:
				heap.display();
				break;
			case 3:
				heap.DeleteMax();
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}