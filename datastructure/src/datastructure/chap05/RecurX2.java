package datastructure.chap05;

import java.util.Scanner;

public class RecurX2 {
	
	static void recur(int n) {
		IntStack s = new IntStack(n);
		
		while(true) {
		if (n > 0) {
			s.push(n);
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);
		}
		}
	}
}