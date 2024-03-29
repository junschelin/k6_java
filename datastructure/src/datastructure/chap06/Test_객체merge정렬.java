package datastructure.chap06;

import java.util.Arrays;

/*
 * 6장 구현 실습과제1 
 */
class PhyscData implements Comparable<PhyscData>{
    String name;              // 이름
    int    height;            // 키
    double vision;            // 시력

   public PhyscData(String name, int height, double vision){
    	this.name = name;
    	this.height = height;
    	this.vision = vision;
    }

	@Override
	public int compareTo(PhyscData o) {
		// TODO Auto-generated method stub
		if (this.height - o.height == 0) {
			if(this.vision - o.vision > 0)
				return 1;
			else if(this.vision - o.vision == 0)
				return 0;
			else
				return -1;
		}
		return this.height - o.height;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}
	
	

}
public class Test_객체merge정렬 {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	
	static void swap(PhyscData[] a, int left, int right) {
		PhyscData temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
	
	static void merge(PhyscData[] a, int lefta, int righta, int leftb, int rightb ) {	
		PhyscData [] temp = new PhyscData[a.length];
		
		int lidx = lefta;
		int ridx = leftb;
		int idx = 0;
		
		while (lidx <= righta && ridx <= rightb) {
			if(a[lidx].compareTo(a[ridx])>0){
				temp[idx++] = a[ridx++];
			}
			else if(a[lidx].compareTo(a[ridx])<0){
				temp[idx++] = a[lidx++];
			}
		}

		
		if (lidx > righta) {
			while(ridx <= rightb) {
				temp[idx++] = a[ridx++];
			}
		}
		if (ridx > rightb) {
			while(lidx <= righta) {
				temp[idx++] = a[lidx++];
			}			
		}
		
		System.out.println(Arrays.toString(temp));
		for (int i=lefta; i < idx; i++) {
			a[i] = temp[i];
		}
		
	}

	// MergeSort 방식 //
	static void MergeSort(PhyscData[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}

	public static void main(String[] args) {
		PhyscData[] x = {
		         new PhyscData("강민하", 162, 0.3),
		         new PhyscData("김찬우", 173, 0.7),
		         new PhyscData("박준서", 171, 2.0),
		         new PhyscData("유서범", 171, 1.5),
		         new PhyscData("이수연", 168, 0.4),
		         new PhyscData("장경오", 171, 1.2),
		         new PhyscData("황지안", 169, 0.8),
		     };
		int nx = x.length;
			System.out.println("정렬 전");
		     System.out.println("■ 신체검사 리스트 ■");
		     System.out.println(" 이름     키  시력");
		     System.out.println("------------------");
			for (int i = 0; i < x.length; i++)
		         System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
		

		   MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬
			System.out.println("오름차순으로 정렬했습니다.");
		     System.out.println("■ 신체검사 리스트 ■");
		     System.out.println(" 이름     키  시력");
		     System.out.println("------------------");
		     for (int i = 0; i < x.length; i++)
		         System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
	}
}
