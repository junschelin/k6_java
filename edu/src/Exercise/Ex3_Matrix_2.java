package Exercise;

public class Ex3_Matrix_2 {
	
	static int[] array = new int[24];
	static int num;
	
	static void input() {
		for (int i = 0; i<array.length; i++) {
			array[i] = i + 1;
		}
	}

	static void ordering() {
		 for (int i = 0; i<array.length; i++) {
			 for (int j = 0; j<array.length; j++) {
				 if(array[i] > array[j]) {
					 num = array[i];
					 array[i] = array[j]; 
					 array[j] = num;
				 }
			 }
		 }
	}
	
	public static void main(String[] args) {
		Ex3_Matrix_2.input();
		Ex3_Matrix_2.ordering();

		for (int i = 0; i<array.length; i++) {
			 System.out.print(array[i] + " ");
		 }
	}
}
